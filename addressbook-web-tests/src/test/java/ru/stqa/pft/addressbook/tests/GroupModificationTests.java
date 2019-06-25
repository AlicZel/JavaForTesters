package ru.stqa.pft.addressbook.tests;

import java.util.HashSet;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification(){
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1",null, null));
    }
    List<GroupData> before=app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size()-1).getId(),"test1","test2","test3");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size()-1);
    before.add(group);
    //nie mozemy porównywać dwóch ArrayList po modyfikacji
    // np. mamy listę before={test1, test2, test3}
    //modyfikujemy nazwę test3 na test1
    // na stronie aplikacja lista grup jest posortowana , więc otrzymamy after={test1, test1, test2},
    //czyli nie da się stwierdzić że ostatni element został zmodyfikowany
    // Set ma tylko unikatowe elementy
    //ale gdy mamy trzy grupy test1, test2, test3 i zmodyfikujemy nazwę grupy test3 na test1 to w set mamy dwa
    // elementy test1 i test2
    // nie byłoby to poprawne porównywanie
    // więc zeby odróżnić grupę w liście mające takie same nazwy dodaliśmy do GroupData pole id , które
    // pobieramy z elementu strony
    // podczas moodyfikiacji zmieniamy nazwe footer, header, ale id pozostawiamy to samo

        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    //Assert.assertEquals(before,after); po dodaniu id - to też zadziała
  }
}

package ru.stqa.pft.addressbook.tests;

import java.util.HashSet;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before=app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    GroupData group =new GroupData("jjjjj", null, null);
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);
    int max = 0;
    for(GroupData g: after){
      if(g.getId()>max){
       max=g.getId();
      }
    }
    //funkcja ananimowa która implementuje funkcję z interfajsu
   // int max1 = after.stream().max( (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    group.setId(after.stream().max( (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}

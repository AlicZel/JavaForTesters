package ru.stqa.pft.addressbook.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1",null, null));
    }
  }

  @Test
  public void testGroupDeletion() {
    List<GroupData> before=app.getGroupHelper().getGroupList();
    int index=before.size()-1;
    app.getGroupHelper().deleteGroup(index);
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(index); //usuwamy ze srtarej listy element który usuneliśmy klkając w aplikacji
    //sprawdzamy w pętli czy string dla elementów z listy before i after są takie same

    //for(int i=0;i<after.size();i++){
    //  Assert.assertEquals(before.get(i),after.get(i));
    Assert.assertEquals(before,after);

    }


}




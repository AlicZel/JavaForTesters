package ru.stqa.pft.addressbook.tests;

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
    app.getGroupHelper().fillGroupForm(new GroupData("jjjjj", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);
  }

}

package ru.stqa.pft.addressbook.tests;

import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupData> before=app.group().all();
    GroupData group =new GroupData().withName("test1");
    app.group().create(group);
    Set<GroupData> after=app.group().all();
    Assert.assertEquals(after.size(),before.size()+1);
    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before,after);
  }

}

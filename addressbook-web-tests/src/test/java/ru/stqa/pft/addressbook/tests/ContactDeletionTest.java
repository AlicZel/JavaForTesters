package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletionFromList(){
    app.getContactHelper().selectContact();
    app.getContactHelper().deletedSelectedContacts();
    app.getContactHelper().confirmAlert();
  }
  @Test
  public void testContactDeletionFromEditMode(){
    app.getContactHelper().clickEditFromList();
    app.getContactHelper().clickDeleteButton();
  }
}

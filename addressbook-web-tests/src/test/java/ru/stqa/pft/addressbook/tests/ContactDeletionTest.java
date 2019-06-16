package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletionFromList(){
    if (!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "test1",
              "Piekna 2\nEłk", "508456456", "uwaga"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deletedSelectedContacts();
    app.getContactHelper().confirmAlert();
  }
  @Test
  public void testContactDeletionFromEditMode(){
    if (!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "test1",
              "Piekna 2\nEłk", "508456456", "uwaga"));
    }
    app.getContactHelper().clickEditFromList();
    app.getContactHelper().clickDeleteButton();
  }
}

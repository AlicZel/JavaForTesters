package ru.stqa.pft.addressbook.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModificationFromList(){
    if (!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "test1",
              "Piekna 2\nEłk", "508456456", "uwaga"));
      app.getContactHelper().goToHomePage();
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().clickEditFromList(before-1);
    app.getContactHelper().fillContactForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", null,
            "Piekna 2\nEłk", "508456456", "uwaga"),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();
    int after=app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);
  }

  @Test
  public void testContactModificationFromDetails() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "test1",
              "Piekna 2\nEłk", "508456456", "uwaga"));
      app.getContactHelper().goToHomePage();}
       List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().goToContactDetails(before.size()-1);
      app.getContactHelper().clickModifyButton();
      app.getContactHelper().fillContactForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", null,
              "Piekna 2\nEłk", "508456456", "uwaga"), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().goToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(),before.size());



  }}


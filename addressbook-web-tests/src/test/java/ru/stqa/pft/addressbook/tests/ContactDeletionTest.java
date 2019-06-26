package ru.stqa.pft.addressbook.tests;

import java.util.List;
import org.testng.Assert;
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
              "17", "November", "1986", "jjjjj",
              "Piekna 2\nEłk", "508456456", "uwaga"));
      app.getContactHelper().goToHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deletedSelectedContacts();
    app.getContactHelper().confirmAlert();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
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
              "17", "November", "1986", "jjjjj",
              "Piekna 2\nEłk", "508456456", "uwaga"));
      app.getContactHelper().goToHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickEditFromList(before.size()-1);
    app.getContactHelper().clickDeleteButton();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);


    before.remove(before.size()-1); //usuwamy ze starej listy element który usuneliśmy klikając w aplikacji
    //sprawdzamy w pętli czy string dla elementów z listy before i after są takie same

   // for(int i=0;i<after.size();i++){
    //  Assert.assertEquals(before.get(i),after.get(i));
  //  }
    Assert.assertEquals(after,before);

  }
}

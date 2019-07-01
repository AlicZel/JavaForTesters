package ru.stqa.pft.addressbook.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void prepareConditions(){
    if (!app.getContactHelper().isThereAContact()){
      app.goTo().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "jjjjj",
              "Piekna 2\nEłk", "508456456", "uwaga"));
    }
  }
  @Test
  public void testContactDeletionFromList(){
    List<ContactData> before = app.getContactHelper().getContactList();
    int index=before.size()-1;
    app.getContactHelper().deleteContact(index);
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
  }



  @Test
  public void testContactDeletionFromEditMode(){
    List<ContactData> before = app.getContactHelper().getContactList();
    int index=before.size()-1;
    app.getContactHelper().deleteContactFromEditForm(index);
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(index);
    Assert.assertEquals(after,before);

  }


}

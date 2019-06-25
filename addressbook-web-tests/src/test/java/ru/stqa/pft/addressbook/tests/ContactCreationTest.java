package ru.stqa.pft.addressbook.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

 @Test
  public void testContactCreation(){
   List<ContactData> before = app.getContactHelper().getContactList();
       app.getNavigationHelper().gotoNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("ALA", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", "jjjjj",
            "Piekna 2\nEłk", "508456456", "uwaga"),true);
    app.getContactHelper().submitNewContactCreation();
    app.getContactHelper().goToHomePage();
    List<ContactData> after=app.getContactHelper().getContactList();
   Assert.assertEquals(after.size(),before.size()+1);
  }


}

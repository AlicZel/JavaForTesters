package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

 @Test
  public void testContactCreation(){
    app.getNavigationHelper().gotoNewContactPage();
    app.getContactHelper().fillNewContactForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", "test1",
            "Piekna 2\nEłk", "508456456", "uwaga"));
    app.getContactHelper().submitNewContactCreation();
  }


}

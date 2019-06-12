package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

 @Test
  public void testContactCreation(){
    gotoNewContactPage();
    fillNewContactForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", "d",
            "Piekna 2\nEłk", "508456456", "uwaga"));
    submitNewContactCreation();
  }


}

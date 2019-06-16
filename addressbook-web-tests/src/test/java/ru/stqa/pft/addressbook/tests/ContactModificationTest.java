package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModificationFromList(){
    app.getContactHelper().clickEditFromList();
    app.getContactHelper().fillContactUpdateForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", "test1",
            "Piekna 2\nEłk", "508456456", "uwaga"));
    app.getContactHelper().submitContactModification();
  }

  @Test
  public void testContactModificationFromDetails()
  {
    app.getContactHelper().goToContactDetails();
    app.getContactHelper().clickModifyButton();
    app.getContactHelper().fillContactUpdateForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", "test1",
            "Piekna 2\nEłk", "508456456", "uwaga"));
    app.getContactHelper().submitContactModification();

  }

}
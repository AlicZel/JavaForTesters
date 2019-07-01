package ru.stqa.pft.addressbook.tests;

import java.util.Comparator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

 @Test
  public void testContactCreation(){
   List<ContactData> before = app.getContactHelper().getContactList();
   ContactData contact =new ContactData("ALA", "Katarzyna", "Zeler", "AliZel",
           "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
           "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
           "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
           "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
           "17", "November", "1986", "jjjjj",
           "Piekna 2\nEłk", "508456456", "uwaga");
   app.goTo().gotoNewContactPage();
    app.getContactHelper().createContact(contact);
    List<ContactData> after=app.getContactHelper().getContactList();
   before.add(contact);
  Comparator<? super ContactData> byId =(g1,g2) -> Integer.compare(g1.getId(),g2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before,after);
  }


}

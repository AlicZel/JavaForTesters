package ru.stqa.pft.addressbook.tests;

import java.util.Comparator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (!app.getContactHelper().isThereAContact()){
      app.goTo().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("Alicja123", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", "test1",
              "Piekna 2\nEłk", "508456456", "uwaga"));
      app.getContactHelper().goToHomePage();
    }
  }
  @Test
  public void testContactModificationFromList(){
    List<ContactData> before = app.getContactHelper().getContactList();
    int index=before.size()-1;
    ContactData contact= new ContactData(before.get(index).getId(),"Alicja_987", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", null,
            "Piekna 2\nEłk", "508456456", "uwaga");
    app.getContactHelper().modifyContact(index,contact);
    List<ContactData> after=app.getContactHelper().getContactList();
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId=(g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after,before);


  }



  @Test()
  public void testContactModificationFromDetails() {
      List<ContactData> before = app.getContactHelper().getContactList();
      int index=before.size()-1;
      ContactData contact =new ContactData(before.get(index).getId(),"Alicja_345", "Katarzyna", "Zeler", "AliZel",
              "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
              "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
              "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
              "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
              "17", "November", "1986", null,
              "Piekna 2\nEłk", "508456456", "uwaga");
    app.getContactHelper().modifyGroupFromDetailsForm(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    before.remove(index);
    before.add(contact);
    Assert.assertEquals(after.size(), before.size());
    Comparator<? super ContactData> byId=(Comparator<ContactData>)(g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after,before);

  }

}


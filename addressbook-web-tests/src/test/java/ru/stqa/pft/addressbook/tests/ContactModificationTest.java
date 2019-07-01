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
      app.getContactHelper().createContact(new ContactData().withName("Alicja_234").withSecondName("Katarzyna").withSurname("Zeler")
              .withNick("AliZel").withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
                      "\\beznazwy.png")
              .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4\nGdańsk").withHomeTel("504123123")
              .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                      withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
              .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
              .withAnniversaryMonth("November").withAnniversaryYear("1986").withGroup("jjjjj")
              .withSecondAddress("Piekna 2\nEłk")
              .withSecondAddressPhone("508456456")
              .withNotes("uwaga"));
      app.getContactHelper().goToHomePage();
    }
  }
  @Test
  public void testContactModificationFromList(){
    List<ContactData> before = app.getContactHelper().getContactList();
    int index=before.size()-1;
    ContactData contact= new ContactData().withName("ALA_345").withSecondName("Katarzyna").withSurname("Zeler")
            .withNick("AliZel").withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
                    "\\beznazwy.png")
            .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4\nGdańsk").withHomeTel("504123123")
            .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                    withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
            .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
            .withAnniversaryMonth("November").withAnniversaryYear("1986").withGroup("jjjjj")
            .withSecondAddress("Piekna 2\nEłk")
            .withSecondAddressPhone("508456456")
            .withNotes("uwaga");
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
      ContactData contact =new ContactData().withName("Alicja_6786").withSecondName("Katarzyna").withSurname("Zeler")
              .withNick("AliZel").withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
                      "\\beznazwy.png")
              .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4\nGdańsk").withHomeTel("504123123")
              .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                      withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
              .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
              .withAnniversaryMonth("November").withAnniversaryYear("1986").withGroup("jjjjj")
              .withSecondAddress("Piekna 2\nEłk")
              .withSecondAddressPhone("508456456")
              .withNotes("uwaga");
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


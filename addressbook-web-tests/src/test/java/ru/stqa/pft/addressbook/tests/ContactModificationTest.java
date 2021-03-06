package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size()==0) {
      app.goTo().newContactPage();
      app.contact().create(new ContactData().withName("Alicja_ZXC").withSecondName("Katarzyna").withSurname(
              "Zeler")
              .withNick("AliZel")
              //.withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
              //        "\\beznazwy.png")
              .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4\nGdańsk").withHomeTel("504123123")
              .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                      withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
              .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
              .withAnniversaryMonth("November").withAnniversaryYear("1986")
              //.withGroup("jjjjj")
              .withSecondAddress("Piekna 2\nEłk")
              .withSecondAddressPhone("508456456")
              .withNotes("uwaga"));
      app.contact().goToHomePage();
    }
  }

  @Test
  public void testContactModificationFromList() {
    Contacts before = app.db().contacts();
    ContactData contact = before.iterator().next();
    ContactData newContact = new ContactData()
            .withId(contact.getId())
            .withName("ALA_345").withSecondName("Katarzyna").withSurname("Zeler")
            .withNick("AliZel")
            //.withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
            //"\\beznazwy.png")
            .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4 Gdańsk").withHomeTel("504123123")
            .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                    withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
            .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
            .withAnniversaryMonth("November").withAnniversaryYear("1986")
            .withSecondAddress("Piekna 2 Ełk")
            .withSecondAddressPhone("508456456")
            .withNotes("uwaga");

    app.contact().modify(newContact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(contact).withAdded(newContact)));

  }


  @Test()
  public void testContactModificationFromDetails() {
    Contacts before = app.db().contacts();
    ContactData contact = before.iterator().next();
    ContactData newContact = new ContactData()
                    .withId(contact.getId())
                    .withName("Alicja_6786").withSecondName("Katarzyna").withSurname("Zeler")
                    .withNick("AliZel")
            //.withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
            //        "\\beznazwy.png")
                    .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4 Gdańsk").withHomeTel(
                    "504123123")
                    .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                    withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
                    .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
                    .withAnniversaryMonth("November").withAnniversaryYear("1986")
                    .withSecondAddress("Piekna 2 Ełk")
                    .withSecondAddressPhone("508456456")
                    .withNotes("uwaga");
    app.contact().modifyFromDetailsForm(newContact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(contact).withAdded(newContact)));
    verifyGroupListInUI();


  }


}


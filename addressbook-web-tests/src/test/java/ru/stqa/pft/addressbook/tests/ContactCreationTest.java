package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("ALA123").withSecondName("Katarzyna").withSurname("Zeler")
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
    app.goTo().gotoNewContactPage();
    app.contact().createContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())).size()));
    assertThat(after, equalTo(before.withAdded(contact)));
  }


}

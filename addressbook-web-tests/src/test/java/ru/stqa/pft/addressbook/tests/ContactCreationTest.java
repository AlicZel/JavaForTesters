package ru.stqa.pft.addressbook.tests;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    System.out.println("Lista before");
    Set<ContactData> before = app.contact().all();
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
    System.out.println("Lista after");
    Set<ContactData> after = app.contact().all();
   contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    System.out.println("Element dodawany do before" + contact);

    before.add(contact);
    Assert.assertEquals(after.size(),before.size());
   Assert.assertEquals(before, after);
  }


}

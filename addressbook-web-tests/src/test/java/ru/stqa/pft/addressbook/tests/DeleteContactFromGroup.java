package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase {
  @BeforeMethod
  public void ensureContact() {
    if (app.db().contacts().size() == 0) {
      app.goTo().newContactPage();
      app.contact().create(new ContactData().withName("Alicja_ZXC").withSecondName("Katarzyna").withSurname(
              "Zeler")
              .withNick("AliZel")
              .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4 Gdańsk").withHomeTel("504123123")
              .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                      withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
              .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
              .withAnniversaryMonth("November").withAnniversaryYear("1986")
              .withSecondAddress("Piekna 2 Ełk")
              .withSecondAddressPhone("508456456")
              .withNotes("uwaga"));
      app.contact().goToHomePage();

    }
  }

  @BeforeMethod
  public void ensureGroup() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testRemoveContactFromGroup() {
    Contacts contactsBefore = app.db().contacts();
    ContactData contact = contactsBefore.iterator().next();
    GroupData newGroup = app.db().groups().iterator().next();
    app.goTo().goToHomePage();
    app.contact().addContactToGroup(contact, newGroup);
    Integer idG = newGroup.getId();
    String idGs = Integer.toString(idG);
    Contacts beforeContactsForSelectedGroup =
            app.db().groups().stream().filter(g -> Integer.toString(g.getId()).equals(idGs)).findFirst().get().getContacts();
    app.goTo().goToHomePage();
    app.contact().removeContactFromGroup(contact, newGroup);
    Contacts afterContactsForSelectedGroup =
            app.db().groups().stream().filter(g -> Integer.toString(g.getId()).equals(idGs)).findFirst().get().getContacts();
    assertThat(beforeContactsForSelectedGroup, equalTo(afterContactsForSelectedGroup.withAdded(contact)));
  }
}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void prepareConditions(){
    if (app.db().contacts().size()==0){
      app.goTo().newContactPage();
      app.contact().create(new ContactData().withName("ALA").withSecondName("Katarzyna").withSurname("Zeler")
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
    }
  }
  @Test()
  public void testContactDeletionFromList(){
    Contacts before = app.db().contacts();
    ContactData contact = before.iterator().next();
    app.contact().delete(contact);
    app.goTo().goToHomePage();
    assertThat(app.group().count(), equalTo(before.size()-1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(contact)));
  }



  @Test
  public void testContactDeletionFromEditMode(){
    Contacts before = app.db().contacts();
    ContactData contact = before.iterator().next();
    app.contact().deleteFromEditForm(contact);
    app.goTo().goToHomePage();
    assertThat(app.group().count(), equalTo(before.size()-1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(contact)));

  }


}

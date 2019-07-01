package ru.stqa.pft.addressbook.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void prepareConditions(){
    if (!app.getContactHelper().isThereAContact()){
      app.goTo().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData().withName("ALA").withSecondName("Katarzyna").withSurname("Zeler")
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
  @Test
  public void testContactDeletionFromList(){
    List<ContactData> before = app.getContactHelper().getContactList();
    int index=before.size()-1;
    app.getContactHelper().deleteContact(index);
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
  }



  @Test
  public void testContactDeletionFromEditMode(){
    List<ContactData> before = app.getContactHelper().getContactList();
    int index=before.size()-1;
    app.getContactHelper().deleteContactFromEditForm(index);
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(index);
    Assert.assertEquals(after,before);

  }


}

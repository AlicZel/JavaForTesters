package ru.stqa.pft.addressbook.tests;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
        if (app.contact().count() == 0) {
      app.goTo().newContactPage();
      app.contact().create(new ContactData().withName("ALA").withSecondName("Katarzyna").withSurname("Zeler")
              .withNick("AliZel").withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
                      "\\beznazwy.png")
              .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4\nGdańsk").withHomeTel("504123123")
              .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                      withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
              .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
              .withAnniversaryMonth("November").withAnniversaryYear("1986")
              //.withGroup("jjjjj")
              .withSecondAddress("Piekna 2\nEłk")
              .withSecondAddressPhone("508456456")
              .withNotes("uwaga"));
    }
  }
  @Test
  public void testContactPhones(){
    app.goTo().goToHomePage();
    ContactData contact= app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  public static String  cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

  private String mergePhones(ContactData contactData){
    return Arrays.asList(contactData.getHomeTel(), contactData.getMobileTel(), contactData.getWorkTel()).stream().filter((s)->!s.equals(""))
            .map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
  }

}

package ru.stqa.pft.addressbook.tests;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {
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
              .withAnniversaryMonth("November").withAnniversaryYear("1986").withGroup("jjjjj")
              .withSecondAddress("Piekna 2\nEłk")
              .withSecondAddressPhone("508456456")
              .withNotes("uwaga"));
    }
  }

  @Test
  public void testContactDetails() {
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm =  app.contact().infoFromEditForm(contact);
    assertThat(app.contact().dataFromDetailsForm(contact).replaceAll("(?m)^[ \t]*\r?\n", "").replaceAll("[\\n\\r]" +
                    ".*Member of:\\s*([^\\n\\r]*)",
            ""),
            equalTo(mergeData(contactInfoFromEditForm)));
  }

  private String mergeData(ContactData contactData) {
    return Arrays.asList(contactData.getName()+" "+ contactData.getSecondName()+" " + contactData.getSurname(),
            contactData.getNick(), contactData.getTitle(), contactData.getCompany(), contactData.getAddress(),
            "H: " + contactData.getHomeTel(), "M: " + contactData.getMobileTel(), "W: " + contactData.getWorkTel(),
            "F: " + contactData.getFax(), contactData.getEmail(), contactData.getEmail2(), contactData.getEmail3(),
            "Homepage:", contactData.getHomepage(),
            "Birthday " + contactData.getBirthDay() + ". " + contactData.getBirthMonth() + " " + contactData.getBirthYear() + " (" + howOld(contactData) + ")",
            "Anniversary " + contactData.getAnniversaryDay() + ". " + contactData.getBirthMonth() + " " + contactData.getAnniversaryYear() + " (" + howManyAniwersary(contactData) + ")",
            contactData.getSecondAddress(), "P: " + contactData.getSecondAddressPhone(), contactData.getNotes()).stream().filter((s) -> !s.equals(""))
            .map(ContactDetailsTest::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("[ \\f\\t\\v]+$", "").replaceAll("[ ]{2,}", " ");
  }


  private static Integer monthToNumber(String month) {
    switch (month) {
      case "January":
        return 1;
      case "February":
        return 2;
      case "March":
        return 3;
      case "April":
        return 4;
      case "May":
        return 5;
      case "June":
        return 6;
      case "July":
        return 7;
      case "August":
        return 8;
      case "September":
        return 9;
      case "October":
        return 10;
      case "November":
        return 11;
      case "December":
        return 12;
      default:
        return 1;
    }
  }

  private Integer howOld(ContactData contact) {
    LocalDate birthDate = LocalDate.of(Integer.parseInt(contact.getBirthYear()),
            monthToNumber(contact.getBirthMonth()),Integer.parseInt(contact.getBirthDay()));
    return (int) DAYS.between(birthDate,LocalDate.now()) / 365;


  }

  private Integer howManyAniwersary(ContactData contact) {
    LocalDate aniwersaryDate = LocalDate.of(Integer.parseInt(contact.getAnniversaryYear()),
            monthToNumber(contact.getAnniversaryMonth()), Integer.parseInt(contact.getAnniversaryDay()));
    return (int) DAYS.between(aniwersaryDate,LocalDate.now()) / 365;

  }
}


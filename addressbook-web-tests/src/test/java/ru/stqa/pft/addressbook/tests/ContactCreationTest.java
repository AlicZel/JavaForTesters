package ru.stqa.pft.addressbook.tests;

import java.io.File;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {
  File photo = new File("src/test/resources/beznazwy.png"); // wzgledna scieżka
  // za pomocą meotdy get absolute na kazdym z reserwa wskazany jest kompletna sciezka do pliku
  //tj. C:/JavaForTesters.....

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("ALA123").withSecondName("Katarzyna").withSurname("Zeler")
            .withNick("AliZel").withPhoto(photo)
            .withTitle("Mrs").withCompany("COMARCH").withAddress("Guderskiego 1/4\nGdańsk").withHomeTel("504123123")
            .withMobileTel("504123123").withWorkTel("504123123").withFax("504123123").withEmail("ala@wp.pl").
                    withEmail2("ala1@wp.pl").withEmail3("ala2@wp.pl").withHomepage("www.wp.pl").withBirthDay("11")
            .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
            .withAnniversaryMonth("November").withAnniversaryYear("1986").withGroup("jjjjj")
            .withSecondAddress("Piekna 2\nEłk")
            .withSecondAddressPhone("508456456")
            .withNotes("uwaga");
    app.goTo().newContactPage();
    app.contact().create(contact);
    assertThat(app.group().count(),
            equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after,
            equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
@Test
  public void testCurentDir(){
    File currentDir= new File(".");
  System.out.println(currentDir.getAbsolutePath());
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());
}

}

package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {
  File photo = new File("src/test/resources/beznazwy.png"); // wzgledna scieżka
  // za pomocą meotdy get absolute na kazdym z reserwa wskazany jest kompletna sciezka do pliku
  //tj. C:/JavaForTesters.....


  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
    String xml ="";
    String line= reader.readLine();
    while(line!=null){
      xml+=line;
      line =reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts= (List<ContactData>)xstream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }}



  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    Contacts before = app.contact().all();
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

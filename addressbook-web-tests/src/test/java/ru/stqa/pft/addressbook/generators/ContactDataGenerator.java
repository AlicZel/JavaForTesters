package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDataGenerator {
  @Parameter(names="-c", description = "Contact count")
  public int count;

  @Parameter(names="-f", description = "Target file")
  public String file;

  @Parameter(names="-d", description = "Data format")
  public String format;




  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator= new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch(ParameterException ex){
      jCommander.usage();
      return;
    }
    new JCommander(generator,args);
    generator.run();


  }

  private void run() throws IOException {

    List<ContactData> contacts= generateContacts(count);
    if(format.equals("csv")){
      saveAsCsv(contacts,new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contacts,new File(file));
    }else {
      System.out.println("Unrecognized format "+format);
    }

  }

  private void saveAsXml(List<ContactData> groups, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(groups);
    try( Writer writer= new FileWriter(file)){
         writer.write(xml);}

  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for(int i=0; i<count;i++){
      contacts.add(
              new ContactData().withName(String.format("ALA123 %s",i)).withSecondName(String.format("Katarzyna %s",i))
                      .withSurname(String.format("Zeler %s",i))
                      .withNick(String.format("AliZel %s",i))
                      .withPhoto(new File("src/test/resources/beznazwy.png"))
                      .withTitle(String.format("Mrs %s",i))
                      .withCompany(String.format("COMARCH %s",i))
                      .withAddress(String.format("Guderskiego 1/4\nGdańsk %s",i))
                      .withHomeTel(String.format("504123123 %s",i))
                      .withMobileTel(String.format("504123123 %s",i))
                      .withWorkTel(String.format("504123123 %s",i))
                              .withFax(String.format("504123123 %s",i))
                      .withEmail(String.format("ala@wp.pl %s",i)).
                      withEmail2(String.format("ala1@wp.pl %s",i)).
                      withEmail3(String.format("ala2@wp.pl %s",i)).
                      withHomepage(String.format("www.wp.pl %s",i))
                      .withBirthDay("11")
                      .withBirthMonth("November").withBirthYear("1986").withAnniversaryDay("17")
                      .withAnniversaryMonth("November").withAnniversaryYear("1986").withGroup("jjjjj")
                      .withSecondAddress("Piekna 2\nEłk")
                      .withSecondAddressPhone("508456456")
                      .withNotes("uwaga")
      );
    }

    return contacts;
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());// biezacy katalog
    try(Writer writer= new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s\n", contact.getName(), contact.getSecondName(), contact.getSurname(),
                contact.getNick(), contact.getPath(), contact.getPhoto(), contact.getTitle(), contact.getCompany(),
                contact.getAddress(), contact.getHomeTel(), contact.getMobileTel(), contact.getWorkTel(),
                contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getHomepage(), contact.getBirthDay(),
                contact.getBirthMonth(), contact.getBirthYear(), contact.getAnniversaryDay(), contact.getAnniversaryMonth(),
                contact.getAnniversaryYear(), contact.getGroup(), contact.getSecondAddress(),
                contact.getSecondAddressPhone(),
                contact.getNotes()
        ));
      }
    }

  }
}

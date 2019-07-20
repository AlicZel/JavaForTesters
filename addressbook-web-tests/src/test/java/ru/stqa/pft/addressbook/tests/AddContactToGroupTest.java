package ru.stqa.pft.addressbook.tests;

import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTest extends TestBase {
  @BeforeMethod
  public void ensureContact() {
    if (app.db().contacts().size()==0) {
      app.goTo().newContactPage();
      app.contact().create(new ContactData().withName("Alicja_ZXC").withSecondName("Katarzyna").withSurname(
              "Zeler")
              .withNick("AliZel")
              //.withPath("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests" +
              //        "\\beznazwy.png")
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
  public void ensureGroup(){
    if(app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));}
  }
  @Test
  public void testAddContactToGroup() {
    ContactData contact =app.db().contacts().iterator().next();
    Groups groupBefore=app.db().groups();
    GroupData newGroup=app.db().groups().iterator().next();
    Integer idNewGroup=newGroup.getId();
    System.out.println("idNewGroup" + idNewGroup);
    app.goTo().goToHomePage();
    app.contact().addContactToGroup(contact,newGroup);
    Groups groupsAfter = app.db().groups();
    System.out.println(" groupsAfter " + groupsAfter);
    GroupData newGroupWithContact = newGroup.withContacts(new Contacts().withAdded(contact));

    List<GroupData> groupsAfterForSelectedContact=
            groupsAfter.stream().filter(g->g.getName().startsWith("test")).collect(Collectors.toList());
    System.out.println("size"+ groupsAfterForSelectedContact.size());
    assertThat(groupsAfterForSelectedContact.get(0),equalTo(newGroupWithContact));



  }
}

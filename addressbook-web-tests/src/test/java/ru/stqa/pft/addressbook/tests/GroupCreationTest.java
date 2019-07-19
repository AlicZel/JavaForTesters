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
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTest extends TestBase {



  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))){
    String xml ="";
    String line= reader.readLine();
    while(line!=null){
      xml+=line;
      line =reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups= (List<GroupData>)xstream.fromXML(xml);
    return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }}


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
      app.goTo().groupPage();
    Groups before=app.db().groups();

      app.group().create(group);
      assertThat(app.group().count(),
              equalTo(before.size()+1));
      Groups after=app.db().groups();
      assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

     }

}

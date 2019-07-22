package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Type;

@XStreamAlias("group")
@Entity
@javax.persistence.Table(name="group_list")
public class GroupData {

  @Id
  @Column(name="group_id")
  private  int id  = Integer.MAX_VALUE;
  @Column(name="group_name")
  private  String name;
  @Column(name="group_header")
  @Type(type="text")
  private  String header;
  @Column(name="group_footer")
  @Type(type="text")
  private  String footer;
  @ManyToMany(mappedBy = "groups",fetch= FetchType.EAGER)
 private Set<ContactData> contacts = new HashSet<ContactData>();
  //private Contacts contacts = new Contacts();

    @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(name, groupData.name) &&
            Objects.equals(header, groupData.header) &&
            Objects.equals(footer, groupData.footer) &&
            Objects.equals(contacts, groupData.contacts);

  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, header, footer);
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public Integer getId() { return id; }

  public Contacts getContacts() {
    return new Contacts(contacts) ;
  }


  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            " name='" + name + '\'' +
            ", header" + header + '\'' +
            ", footer='" + footer + '\'' +
           // ", contacts='" + contacts + '\'' +
            '}';
  }

  public String getFooter() {
    return footer;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }
  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public GroupData withContacts(Contacts contacts){
      this.contacts=contacts;
      return this;
  }



}

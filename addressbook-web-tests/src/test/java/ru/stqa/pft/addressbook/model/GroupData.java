package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@XStreamAlias("group")
@Entity
@javax.persistence.Table(name="group_list")
public class GroupData {
  @XStreamOmitField
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
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }





  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public Integer getId() { return id; }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
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

}

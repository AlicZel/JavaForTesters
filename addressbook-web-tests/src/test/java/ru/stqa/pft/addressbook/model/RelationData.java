package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("relations")
@Entity
@Table(name= "address_in_groups")
public class RelationData {
  @XStreamOmitField
@Id
private Integer domain_id;
   @Column(name="group_id")
  private Integer groupId;
  @Column(name = "id")
  private Integer contactId;

  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RelationData that = (RelationData) o;
    return Objects.equals(groupId, that.groupId) &&
            Objects.equals(contactId, that.contactId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupId, contactId);
  }

}

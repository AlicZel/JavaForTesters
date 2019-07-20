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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;

@XStreamAlias("contact")
@Entity
@Table(name= "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name ="id")
  private Integer id=Integer.MAX_VALUE;
  @Column(name="firstname")
  @Type(type="string")
  String name;
  @Column(name="middlename")
  @Type(type="string")
  private  String secondName;
  @Column(name="lastname")
  @Type(type="string")
  private  String surname;
  @Column(name="nickname")
  @Type(type="string")
  private  String nick;
@Transient
  private  String path;
  @Column(name="title")
  @Type(type="string")
  private  String title;
  @Column(name="company")
  private  String company;
  @Column(name="address")
  @Type(type="text")
  private  String address;
  @Column(name="home")
  @Type(type="text")
  private  String homeTel;
  @Column(name="mobile")
  @Type(type="text")
  private  String mobileTel;
  @Column(name="work")
  @Type(type="text")
  private  String workTel;
  @Column(name="fax")
  @Type(type="text")
  private  String fax;
  @Column(name="email")
  @Type(type="text")
  private  String email;
  @Column(name="email2")
  @Type(type="text")
  private  String email2;
  @Column(name="email3")
  @Type(type="text")
  private  String email3;
  @Column(name="homepage")
  @Type(type="text")
  private  String homepage;
  @Column(name="bday")
  private  Byte birthDay;
  @Column(name="bmonth")
  private  String birthMonth;
  @Column(name="byear")
  private  String birthYear;
  @Column(name="aday")
  private Byte anniversaryDay;
  @Column(name="amonth")
  private String anniversaryMonth;
  @Column(name="ayear")
  private  String anniversaryYear;
  @Column(name="address2")
  @Type(type="text")
  private  String secondAddress;
  @Column(name="phone2")
  @Type(type="text")
  private  String secondAddressPhone;
  @Column(name="notes")
  @Type(type="text")
  private  String notes;
  @Transient
  private String allPhones;
@Transient
  private String allEmails;
@ManyToMany(fetch= FetchType.EAGER)
@JoinTable(name="address_in_groups", joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name=
        "group_id"))
private Set<GroupData> groups = new HashSet<GroupData>();


//  @Column(name="photo")
//  @Type(type="text")
 // private String photo;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getSurname() {
    return surname;
  }

  public String getNick() {
    return nick;
  }

  public String getPath() {
    return path;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomeTel() {
    return homeTel;
  }

  public String getMobileTel() {
    return mobileTel;
  }

  public String getWorkTel() {
    return workTel;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBirthDay() {
    return birthDay.toString();
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getAnniversaryDay() {
    return anniversaryDay.toString();
  }

  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }

  public String getAnniversaryYear() {
    return anniversaryYear;
  }

  public String getSecondAddress() {
    return secondAddress;
  }


  public String getSecondAddressPhone() {
    return secondAddressPhone;
  }

  public String getNotes() {
    return notes;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactData withId(Integer id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withSecondName(String secondName) {
    this.secondName = secondName;
    return this;
  }

  public ContactData withSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public ContactData withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public ContactData withPath(String path) {
    this.path = path;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company =company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomeTel(String homeTel) {
    this.homeTel = homeTel;
    return this;
  }

  public ContactData withMobileTel(String mobileTel) {
    this.mobileTel = mobileTel;
    return this;
  }

  public ContactData withWorkTel(String workTel) {
    this.workTel = workTel;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBirthDay(String birthDay) {
    this.birthDay =Byte.parseByte(birthDay);
    return this;
  }

  public ContactData withBirthMonth(String birthMonth) {
    this.birthMonth = birthMonth;
    return this;
  }

  public ContactData withBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public ContactData withAnniversaryDay(String anniversaryDay) {
   this.anniversaryDay=Byte.parseByte(anniversaryDay);
       return this;
  }

  public ContactData withAnniversaryMonth(String anniversaryMonth) {
    this.anniversaryMonth = anniversaryMonth;
    return this;
  }

  public ContactData withAnniversaryYear(String anniversaryYear) {
    this.anniversaryYear = anniversaryYear;
    return this;
  }

  public ContactData withSecondAddress(String secondAddress) {
    this.secondAddress = secondAddress;
    return this;
  }

  public ContactData withSecondAddressPhone(String secondAddressPhone) {
    this.secondAddressPhone = secondAddressPhone;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  //public File getPhoto() {
  //  return new File(photo);
  //}
  //
  //public ContactData withPhoto(File photo) {
  //  this.photo = photo.getPath();
  //  return this;
  //}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(secondName, that.secondName) &&
            Objects.equals(surname, that.surname) &&
            Objects.equals(nick, that.nick) &&
            Objects.equals(title, that.title) &&
            Objects.equals(company, that.company) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homeTel, that.homeTel) &&
            Objects.equals(mobileTel, that.mobileTel) &&
            Objects.equals(workTel, that.workTel) &&
            Objects.equals(fax, that.fax) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3) &&
            Objects.equals(homepage, that.homepage) &&
            Objects.equals(birthDay, that.birthDay) &&
            Objects.equals(birthMonth, that.birthMonth) &&
            Objects.equals(birthYear, that.birthYear) &&
            Objects.equals(anniversaryDay, that.anniversaryDay) &&
            Objects.equals(anniversaryMonth, that.anniversaryMonth) &&
            Objects.equals(anniversaryYear, that.anniversaryYear) &&
            Objects.equals(secondAddress, that.secondAddress) &&
            Objects.equals(secondAddressPhone, that.secondAddressPhone) &&
            Objects.equals(notes, that.notes) &&
              Objects.equals(groups, that.groups);


  }

  @Override
  public int hashCode() {
    return Objects.hash(name, secondName, surname, nick, title, company, address, homeTel, mobileTel, workTel,
            fax, email, email2, email3, homepage, birthDay, birthMonth, birthYear, anniversaryDay, anniversaryMonth,
            anniversaryYear, secondAddress, secondAddressPhone, notes,groups);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", secondName='" + secondName + '\'' +
            ", surname='" + surname + '\'' +
            ", nick='" + nick + '\'' +
            ", title='" + title + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", homeTel='" + homeTel + '\'' +
            ", mobileTel='" + mobileTel + '\'' +
            ", workTel='" + workTel + '\'' +
            ", fax='" + fax + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", homepage='" + homepage + '\'' +
            ", birthDay=" + birthDay +
            ", birthMonth='" + birthMonth + '\'' +
            ", birthYear='" + birthYear + '\'' +
            ", anniversaryDay=" + anniversaryDay +
            ", anniversaryMonth='" + anniversaryMonth + '\'' +
            ", anniversaryYear='" + anniversaryYear + '\'' +
            ", secondAddress='" + secondAddress + '\'' +
            ", secondAddressPhone='" + secondAddressPhone + '\'' +
            ", notes='" + notes + '\'' +
            '}';
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withGroups(Groups groups) {
    this.groups = groups;
    return this;
  }

}

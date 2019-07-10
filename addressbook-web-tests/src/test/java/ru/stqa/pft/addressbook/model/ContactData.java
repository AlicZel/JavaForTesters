package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private Integer id=Integer.MAX_VALUE;
  private  String name;
  private  String secondName;
  private  String surname;
  private  String nick;
  private  String path;
  private  String title;
  private  String company;
  private  String address;
  private  String homeTel;
  private  String mobileTel;
  private  String workTel;
  private  String fax;
  private  String email;
  private  String email2;
  private  String email3;
  private  String homepage;
  private  String birthDay;
  private  String birthMonth;
  private  String birthYear;
  private  String anniversaryDay;
  private String anniversaryMonth;
  private  String anniversaryYear;
  private  String group;
  private  String secondAddress;
  private  String secondAddressPhone;
  private  String notes;
  private String allPhones;
  private String allEmails;
  private File photo;

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
    return birthDay;
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getAnniversaryDay() {
    return anniversaryDay;
  }

  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }

  public String getAnniversaryYear() {
    return anniversaryYear;
  }

  public String getGroup() {
    return group;
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
    this.company = company;
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
    this.birthDay = birthDay;
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
    this.anniversaryDay = anniversaryDay;
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

  public ContactData withGroup(String group) {
    this.group = group;
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

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='"+id +'\''+
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", address='" + address + '\'' +
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



}

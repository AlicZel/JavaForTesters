package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String name;
  private final String secondName;
  private final String surname;
  private final String nick;
  private final String path;
  private final String title;
  private final String company;
  private final String address;
  private final String homeTel;
  private final String mobileTel;
  private final String workTel;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String birthDay;
  private final String birthMonth;
  private final String birthYear;
  private final String anniversaryDay;
  private final String anniversaryMonth;
  private final String anniversaryYear;
  private final String group;
  private final String secondAddress;
  private final String secondAddressPhone;
  private final String notes;

  public ContactData(String name, String secondName, String surname, String nick, String path, String title, String company, String address, String homeTel, String mobileTel, String workTel, String fax, String email, String email2, String email3, String homepage, String birthDay, String birthMonth, String birthYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String group, String secondAddress, String secondAddressPhone, String notes) {
    this.name = name;
    this.secondName = secondName;
    this.surname = surname;
    this.nick = nick;
    this.path = path;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homeTel = homeTel;
    this.mobileTel = mobileTel;
    this.workTel = workTel;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.anniversaryDay = anniversaryDay;
    this.anniversaryMonth = anniversaryMonth;
    this.anniversaryYear = anniversaryYear;
    this.group = group;
    this.secondAddress = secondAddress;
    this.secondAddressPhone = secondAddressPhone;
    this.notes = notes;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname);
  }
}

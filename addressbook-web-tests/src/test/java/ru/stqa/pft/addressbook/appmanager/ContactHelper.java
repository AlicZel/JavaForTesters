package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitNewContactCreation() {
    click(By.xpath("//input[@name='submit']"));
  }

  public void fillNewContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getSecondName());
    type(By.name("lastname"), contactData.getSecondName());
    type(By.name("nickname"), contactData.getNick());
    typePath(By.name("photo"), contactData.getPath());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomeTel());
    type(By.name("mobile"), contactData.getMobileTel());
    type(By.name("work"), contactData.getWorkTel());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());
    click(By.name("bday"));
    selectOptionFromComboBox(By.name("bday"), contactData.getBirthDay());
    click(By.name("bmonth"));
    selectOptionFromComboBox(By.name("bmonth"), contactData.getBirthMonth());
    type(By.name("byear"), contactData.getBirthYear());
    click(By.name("aday"));
    selectOptionFromComboBox(By.name("aday"), contactData.getAnniversaryDay());
    click(By.name("amonth"));
    selectOptionFromComboBox(By.name("amonth"), contactData.getAnniversaryMonth());
    type(By.name("ayear"), contactData.getAnniversaryYear());
    click(By.name("new_group"));
    selectOptionFromComboBox(By.name("new_group"), contactData.getGroup());
    type(By.name("address2"), contactData.getSecondAddress());
    type(By.name("phone2"), contactData.getSecondAddressPhone());
    type(By.name("notes"), contactData.getNotes());
  }

}

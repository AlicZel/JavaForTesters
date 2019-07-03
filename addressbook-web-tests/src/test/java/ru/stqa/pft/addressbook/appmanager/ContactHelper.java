package ru.stqa.pft.addressbook.appmanager;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

public class ContactHelper extends HelperBase {

  private Contacts contactsCache = null;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContactCreation() {
    click(By.xpath("//input[@name='submit']"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getSecondName());
    type(By.name("lastname"), contactData.getSurname());
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
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("address2"), contactData.getSecondAddress());
    type(By.name("phone2"), contactData.getSecondAddressPhone());
    type(By.name("notes"), contactData.getNotes());
  }


  public void deletedSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }


  public void submitContactModification() {
    click(By.name("update"));

  }


  public void goToContactDetailsById(int id) {
    if (isElementPresent(By.name("modifiy"))) {
      return;
    }
    wd.findElement(By.cssSelector("[href='view.php?id=" + id + "']")).click();
  }

  public void clickModifyButton() {
    click(By.name("modifiy"));
  }


  public void clickDeleteButton() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void create(ContactData contactData) {
    fillContactForm(contactData, true);
    submitNewContactCreation();
    goToHomePage();
    contactsCache = null;
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deletedSelectedContacts();
    confirmAlert();
    contactsCache = null;
  }

  private void selectContactById(Integer id) {
    click(By.xpath("//input[@value='" + id + "']"));
  }


  public void deleteFromEditForm(ContactData contact) {
    clickEditById(contact.getId());
    clickDeleteButton();
    contactsCache = null;
  }

  private void clickEditById(Integer id) {
    wd.findElement(By.cssSelector("[href='edit.php?id=" + id + "']")).click();
  }


  public void modify(ContactData contact) {
    clickEditById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    goToHomePage();
    contactsCache = null;
  }

  public void modifyFromDetailsForm(ContactData contact) {
    goToContactDetailsById(contact.getId());
    clickModifyButton();
    fillContactForm(contact, false);
    submitContactModification();
    goToHomePage();
    contactsCache = null;

  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//tr[2]/td/input"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }


  public Contacts all() {
    if (contactsCache != null) {
      return new Contacts(contactsCache);
    }
    contactsCache = new Contacts();

    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String surName = element.findElement(By.xpath(".//td[2]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      Integer id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact =
              new ContactData().withId(id).withName(name).withSurname(surName).withAddress(address)
                      .withAllPhones(allPhones).withAllPhones(address).withAllEmails(allEmails);
      contactsCache.add(contact);
    }
    return new Contacts(contactsCache);

  }

  public String dataFromDetailsForm(ContactData contactData){
    initViewById(contactData.getId());
    return wd.findElement(By.id("content")).getText();

  }

  public ContactData infoFromEditForm(ContactData contact) {
    initModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String secondName = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String path = wd.findElement(By.name("photo")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String homeTel = wd.findElement(By.name("home")).getAttribute("value");
    String mobileTel = wd.findElement(By.name("mobile")).getAttribute("value");
    String workTel = wd.findElement(By.name("work")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
    String bday = wd.findElement(By.name("bday")).getAttribute("value");
    String bmonth = wd.findElement(By.name("bmonth")).getAttribute("value");
    String byear = wd.findElement(By.name("byear")).getAttribute("value");
    String aday = wd.findElement(By.name("aday")).getAttribute("value");
    String amonth = wd.findElement(By.name("amonth")).getAttribute("value");
    String ayear = wd.findElement(By.name("ayear")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstName).withSecondName(secondName).withSurname(lastName)
            .withNick(nickname).withPath(path)
            .withTitle(title).withCompany(company).withAddress(address).withHomeTel(homeTel)
            .withMobileTel(mobileTel).withWorkTel(workTel).withFax(fax).withEmail(email).
                    withEmail2(email2).withEmail3(email3).withHomepage(homepage).withBirthDay(bday)
            .withBirthMonth(bmonth).withBirthYear(byear).withAnniversaryDay(aday)
            .withAnniversaryMonth(amonth).withAnniversaryYear(ayear)
            .withSecondAddress(address2)
            .withSecondAddressPhone(phone2)
            .withNotes(notes);

  }

  private void initModificationById(Integer id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }

  private void initViewById(Integer id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']",id))).click();
  }
}

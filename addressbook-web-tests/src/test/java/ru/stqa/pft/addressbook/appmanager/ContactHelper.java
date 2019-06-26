package ru.stqa.pft.addressbook.appmanager;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {

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


  public void selectContact(int index) {
    wd.findElements(By.xpath("//tr/td/input")).get(index).click();
  }

  public void deletedSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void clickEditFromList(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));

  }

  public void goToContactDetails(int index) {
    if(isElementPresent(By.name("modifiy"))){
      return;
    }
    wd.findElements(By.xpath("//img[@alt='Details']")).get(index).click();
  }

  public void clickModifyButton() {
    click(By.name("modifiy"));
  }


  public void clickDeleteButton() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void createContact(ContactData contactData) {
   fillContactForm(contactData,true);
   submitNewContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//tr[2]/td/input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void goToHomePage() {
      if(isElementPresent(By.id("maintable"))){
        return;
      }
      click(By.linkText("home page"));
    }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath("//td[3]")).getText();
      String surName = element.findElement(By.xpath("//td[2]")).getText();
      ContactData contact = new ContactData(name, null, surName, null, null, null, null, null, null, null, null,
              null, null, null, null, null, null, null, null, null, null, null, null,
              null, null, null);

      contacts.add(contact);
    }
    return contacts;
    }
  }

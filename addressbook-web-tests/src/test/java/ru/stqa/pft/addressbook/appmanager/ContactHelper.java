package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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
    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {Assert.assertFalse(isElementPresent(By.name("new_group")));}

    type(By.name("address2"), contactData.getSecondAddress());
    type(By.name("phone2"), contactData.getSecondAddressPhone());
    type(By.name("notes"), contactData.getNotes());
  }


  public void selectContact() {
    click(By.xpath("//tr[2]/td/input"));
  }

  public void deletedSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void clickEditFromList() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
      click(By.name("update"));

  }

  public void goToContactDetails() {
    click(By.xpath("//img[@alt='Details']"));
  }

  public void clickModifyButton() {
    click(By.name("modifiy"));
  }


  public void clickDeleteButton() {
    click(By.xpath("//input[@value='Delete']"));
  }
}

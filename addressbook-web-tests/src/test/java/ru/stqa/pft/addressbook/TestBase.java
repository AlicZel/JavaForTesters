package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class TestBase {
  protected WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login();
  }

  private void login() {
    wd.get("http://localhost:8080/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  protected void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  protected void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  protected void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  protected void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  protected void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  protected void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  protected void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  protected void submitNewContactCreation() {
    wd.findElement(By.xpath("//input[@name='submit']")).click();
  }

  protected void fillNewContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    wd.findElement(By.name("middlename")).sendKeys(contactData.getSecondName());
    wd.findElement(By.name("lastname")).sendKeys(contactData.getSurname());
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNick());
    wd.findElement(By.name("photo")).sendKeys(contactData.getPath());
    wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("home")).sendKeys(contactData.getHomeTel());
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobileTel());
    wd.findElement(By.name("work")).sendKeys(contactData.getWorkTel());
    wd.findElement(By.name("fax")).sendKeys(contactData.getFax());
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
    wd.findElement(By.name("byear")).sendKeys(contactData.getBirthYear());
    wd.findElement(By.name("aday")).click();
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAnniversaryDay());
    wd.findElement(By.name("amonth")).click();
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnniversaryMonth());
    wd.findElement(By.name("ayear")).sendKeys(contactData.getAnniversaryYear());
    wd.findElement(By.name("new_group")).click();
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    wd.findElement(By.name("address2")).sendKeys(contactData.getSecondAddress());
    wd.findElement(By.name("phone2")).sendKeys(contactData.getSecondAddressPhone());
    wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
  }

  protected void gotoNewContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}

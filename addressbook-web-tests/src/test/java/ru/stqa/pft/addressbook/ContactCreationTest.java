package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class ContactCreationTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContactCreation() throws Exception {
    login();
    gotoNewContactPage("add new");
    fillNewContactForm(new ContactData("Alicja", "Katarzyna", "Zeler", "AliZel",
            "D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web-tests\\beznazwy.png",
            "Mrs", "COMARCH", "Guderskiego 1/4\nGdańsk", "504123123",
            "504123123", "504123123", "504123123", "ala@wp.pl", "ala1@wp.pl",
            "ala2@wp.pl", "www.wp.pl", "11", "November", "1986",
            "17", "November", "1986", "d",
            "Piekna 2\nEłk", "508456456", "uwaga"));
    submitNewContactCreation("//input[@name='submit']");
    returnToHomePage("home page");
    logout("Logout");
  }

  private void logout(String logout) {
    driver.findElement(By.linkText(logout)).click();
  }

  private void returnToHomePage(String s) {
    driver.findElement(By.linkText(s)).click();
  }

  private void submitNewContactCreation(String s) {
    driver.findElement(By.xpath(s)).click();
  }

  private void fillNewContactForm(ContactData contactData) {
    driver.findElement(By.name("firstname")).sendKeys(contactData.getName());
    driver.findElement(By.name("middlename")).sendKeys(contactData.getSecondName());
    driver.findElement(By.name("lastname")).sendKeys(contactData.getSurname());
    driver.findElement(By.name("nickname")).sendKeys(contactData.getNick());
    driver.findElement(By.name("photo")).sendKeys(contactData.getPath());
    driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
    driver.findElement(By.name("company")).sendKeys(contactData.getCompany());
    driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
    driver.findElement(By.name("home")).sendKeys(contactData.getHomeTel());
    driver.findElement(By.name("mobile")).sendKeys(contactData.getMobileTel());
    driver.findElement(By.name("work")).sendKeys(contactData.getWorkTel());
    driver.findElement(By.name("fax")).sendKeys(contactData.getFax());
    driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    driver.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    driver.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    driver.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
    driver.findElement(By.name("bday")).click();
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
    driver.findElement(By.name("bmonth")).click();
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
    driver.findElement(By.name("byear")).sendKeys(contactData.getBirthYear());
    driver.findElement(By.name("aday")).click();
    new Select(driver.findElement(By.name("aday"))).selectByVisibleText(contactData.getAnniversaryDay());
    driver.findElement(By.name("amonth")).click();
    new Select(driver.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnniversaryMonth());
    driver.findElement(By.name("ayear")).sendKeys(contactData.getAnniversaryYear());
    driver.findElement(By.name("new_group")).click();
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    driver.findElement(By.name("address2")).sendKeys(contactData.getSecondAddress());
    driver.findElement(By.name("phone2")).sendKeys(contactData.getSecondAddressPhone());
    driver.findElement(By.name("notes")).sendKeys(contactData.getNotes());
  }

  private void gotoNewContactPage(String s) {
    driver.findElement(By.linkText(s)).click();
  }

  private void login() {
    driver.get("http://localhost:8080/addressbook/");
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }


}

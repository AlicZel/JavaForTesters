package ru.stqa.pft.addressbook;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
    fillNewContactForm();
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

  private void fillNewContactForm() {
    driver.findElement(By.name("firstname")).sendKeys("Alicja");
    driver.findElement(By.name("middlename")).sendKeys("Katarzyna");
    driver.findElement(By.name("lastname")).sendKeys("Zeler");
    driver.findElement(By.name("nickname")).sendKeys("AliZel");
    driver.findElement(By.name("photo")).sendKeys("D:\\SzkolenieJavaDlaTesterów\\JavaForTesters\\addressbook-web" +
            "-tests\\beznazwy.png");
    driver.findElement(By.name("title")).sendKeys("Mrs");
    driver.findElement(By.name("company")).sendKeys("COMARCH");
    driver.findElement(By.name("address")).sendKeys("Guderskiego 1/4\nGdańsk");
    driver.findElement(By.name("home")).sendKeys("504123123");
    driver.findElement(By.name("mobile")).sendKeys("504123123");
    driver.findElement(By.name("work")).sendKeys("504123123");
    driver.findElement(By.name("fax")).sendKeys("504123123");
    driver.findElement(By.name("email")).sendKeys("ala@wp.pl");
    driver.findElement(By.name("email2")).sendKeys("ala1@wp.pl");
    driver.findElement(By.name("email3")).sendKeys("ala2@wp.pl");
    driver.findElement(By.name("homepage")).sendKeys("www.wp.pl");
    driver.findElement(By.name("bday")).click();
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("11");
    driver.findElement(By.name("bmonth")).click();
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("November");
    driver.findElement(By.name("byear")).sendKeys("1986");
    driver.findElement(By.name("aday")).click();
    new Select(driver.findElement(By.name("aday"))).selectByVisibleText("17");
    driver.findElement(By.name("amonth")).click();
    new Select(driver.findElement(By.name("amonth"))).selectByVisibleText("November");
    driver.findElement(By.name("ayear")).sendKeys("1986");
    driver.findElement(By.name("new_group")).click();
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("d");
    driver.findElement(By.name("address2")).sendKeys("Piekna 2\nEłk");
    driver.findElement(By.name("phone2")).sendKeys("508456456");
    driver.findElement(By.name("notes")).sendKeys("uwaga");
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

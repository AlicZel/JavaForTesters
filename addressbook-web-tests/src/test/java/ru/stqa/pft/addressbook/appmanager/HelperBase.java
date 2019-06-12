package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  FirefoxDriver wd;

  public HelperBase(FirefoxDriver wd) {
    this.wd=wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  protected void typePath(By locator, String text) {
       wd.findElement(locator).sendKeys(text);
  }
  protected void selectOptionFromComboBox(By locator, String option) {
    new Select(wd.findElement(locator)).selectByVisibleText(option);
  }

  public void confirmAlert() {
    wd.switchTo().alert().accept();
  }
}

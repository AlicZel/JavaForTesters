package ru.stqa.pft.addressbook.appmanager;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd=wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if(text!=null){
      String existingTest=wd.findElement(locator).getAttribute("value"); // getText dla innych pól niz input
      if(!text.equals(existingTest)){
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
      }
  }}

  protected void attach(By locator, File file) {
    if(file!=null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
    }

  protected void typePath(By locator, String text){
    if(text!=null){
    String existingTest=wd.findElement(locator).getAttribute("value"); // getText dla innych pól niz input
    if(!text.equals(existingTest)){
      wd.findElement(locator).sendKeys(text);
    }
  }}

  protected void selectOptionFromComboBox(By locator, String option) {
    new Select(wd.findElement(locator)).selectByVisibleText(option);
  }

  public void confirmAlert() {
    wd.switchTo().alert().accept();
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return  true;
    } catch (NoSuchElementException ex){
      return false;
    }

  }
}

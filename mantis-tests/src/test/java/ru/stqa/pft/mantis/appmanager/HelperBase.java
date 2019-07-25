package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  protected ApplicationManager app;
  protected WebDriver wd;

  public HelperBase(ApplicationManager app)
  {this.app=app;
    this.wd=app.getDriver();
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

  protected void attach(By locator, String path) {
    if(path!=null) {
      wd.findElement(locator).sendKeys(path);
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

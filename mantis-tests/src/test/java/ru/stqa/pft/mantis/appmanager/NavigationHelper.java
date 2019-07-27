package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void manage(){
//    if(isElementPresent((By.linkText("Manage Users")))){
//      return;
//    }
    click((By.linkText("Manage")));
  }
  public void manageUsers(){

    click((By.linkText("Manage Users")));
  }

}

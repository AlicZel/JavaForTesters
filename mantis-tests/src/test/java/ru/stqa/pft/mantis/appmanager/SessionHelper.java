package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void loginAsAdmin() {
    type(By.name("username"), app.getProperty("web.adminLogin"));
    type(By.name("password"),app.getProperty("web.adminPassword"));
    click(By.xpath("//input[@value='Login']"));
  }

  public void logout() {
    click(By.linkText("Logout"));
  }
}

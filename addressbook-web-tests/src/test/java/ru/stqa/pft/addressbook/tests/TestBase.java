package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp(){
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(){
    app.stop();
  }

}

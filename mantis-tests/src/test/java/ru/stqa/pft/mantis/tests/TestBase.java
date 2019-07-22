package ru.stqa.pft.mantis.tests;

import java.io.IOException;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

public class TestBase {


  protected static final ApplicationManager app =
          new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown(){
    app.stop();
  }


}
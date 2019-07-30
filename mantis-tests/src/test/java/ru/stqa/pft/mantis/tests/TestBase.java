package ru.stqa.pft.mantis.tests;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Properties;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.*;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.rpc.ServiceException;

public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        app.init();
        //  app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {

        // app.ftp().restore("config_inc.php.bak","config_inc.php");
        app.stop();
    }

    private boolean isIssueOpen(BigInteger issueId) throws RemoteException, ServiceException, MalformedURLException {
        if ((app.soup().getIssueStatus(issueId).equals("closed") || app.soup().getIssueStatus(issueId).equals("resolved"))) {
            return false;
        } else return true;
    }


    public void skipIfNotFixed(BigInteger issueId) throws RemoteException, ServiceException, MalformedURLException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}

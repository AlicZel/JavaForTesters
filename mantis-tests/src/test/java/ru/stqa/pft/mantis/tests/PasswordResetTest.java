package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PasswordResetTest extends TestBase{


    @BeforeMethod
    public void startMailServer(){
       app.mail().start();
    }

    @Test
    public void testPasswordReset() throws IOException, MessagingException {

        UserData userData =app.db().users().iterator().next();
        String email = userData.getEmail();
        app.session().loginAsAdmin();
        String newPassword = "password";
        app.passwordReset().start(userData.getUsername());
        List<MailMessage> mailMessages = app.mail().waitForMail(1,10000);
        String confirmationLink =findConfirmationLink(mailMessages,email);
        app.passwordReset().finish(confirmationLink, newPassword);
       assertTrue(app.newSession().login(userData.getUsername(),newPassword));

    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex=VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}

package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class PasswordResetHelper extends HelperBase {
    public PasswordResetHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username) {
        app.goTo().manage();
        app.goTo().manageUsers();
        app.manageUsers().searchUser(username).clickManageUser();
       click(By.cssSelector("input[value='Reset Password']"));
    }
    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.cssSelector("input[value='Update User']"));

    }
}

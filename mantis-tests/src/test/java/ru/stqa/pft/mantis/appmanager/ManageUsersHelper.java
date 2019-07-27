package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class ManageUsersHelper extends HelperBase {
    public ManageUsersHelper(ApplicationManager app) {
        super(app);
    }

    public ManageUsersHelper searchUser(String username){
        type(By.cssSelector("input[name='username']"),username);

        return this;
         }

         public void clickManageUser(){
        click(By.cssSelector("input[value='Manage User']"));
         }
}

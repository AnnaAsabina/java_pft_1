package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTests extends TestBase {
  WebDriver wd;
  @BeforeMethod
    public void startMailServer() {
    app.mail().start();
  }
    @Test
            public void changePasswordTests(){
app.session().loginToMantis();
app.session().goToUsersPage();
    }

  @AfterMethod(alwaysRun = true)
 public void stopMailServer(){
           app.mail().stop();
  }
      }


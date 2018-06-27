package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
public SessionHelper(ApplicationManager app) {

    super(app);
  }

  public void loginToMantis() {
  String username = app.getProperty("web.adminLogin");
  String password = app.getProperty("web.adminPassword");
  wd.get(app.getProperty("web.baseUrl"));

    type(By.name("username"),username);
    click(By.cssSelector("input[type='submit']"));
    type(By.name("password"), password);
           click(By.cssSelector("input[type='submit']"));

  }
  public void goToUsersPage(){
  wd.get(app.getProperty("web.baseUrl"+"manage_user_page.php"));
  }
}

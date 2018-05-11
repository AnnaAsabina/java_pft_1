package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void contactCreationTests() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Annatest", "Pvalovnatest", "Asabinatest", "Adresstest", "+7888888888888", "anna@test.test"));
    app.getContactHelper().submitContact();
    app.getContactHelper().returnHomePage();
  }
}
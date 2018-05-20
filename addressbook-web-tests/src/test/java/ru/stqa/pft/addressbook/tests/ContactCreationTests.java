package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void contactCreationTests() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().creationContact(new ContactData("Annatest", "Pvalovnatest", "Asabinatest", "Adresstest", "+7888888888888", "anna@test.test","test1"),true);
  }
}
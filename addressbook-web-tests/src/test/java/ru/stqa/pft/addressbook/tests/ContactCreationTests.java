package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void contactCreationTests() {
    app.getContactHelper().initContactCreation();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Annatest", "Pvalovnatest", "Asabinatest", "Adresstest", "+7888888888888", "anna@test.test","test1");
    app.getContactHelper().creationContact(contact,true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
           for (ContactData g : after) {
                  if (g.getId() > max){
                        max = g.getId();
                   }
              }
          contact.setId(max);
           before.add(contact);
           Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
}
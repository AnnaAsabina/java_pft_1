package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Olga", "Ivanovna", "Ivanova", "Kosmonavtov 26", "336366363", "ivanova@test"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnHomePage();
  }

}
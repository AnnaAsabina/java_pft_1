package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();

    if (! app.getContactHelper().isContactExist()){
      app.getContactHelper().creationContact(new ContactData("testFirstName1", "testMiddleName1", "testLastName1", "testAddress1", "+79797979797", "test@test.test", "test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Olga", "Ivanovna", "Ivanova", "Kosmonavtov 26", "336366363", "ivanova@test",null),false
    );
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnHomePage();
  }

}
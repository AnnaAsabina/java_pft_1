package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test(enabled = true)

  public void contactCreationTests() {
    app.goTo().goToHomePage();
    Contacts before = app.contact().all();
    app.contact().initContactCreation();
  ContactData contact = new ContactData().withFirstName("Annatest2").withLastName("Asabinatest").withAddress("Kosmonavtov26").withGroup("test1")
          .withHomePhone("111").withMobilePhone("222").withWorkPhone("333");
    app.contact().create(contact,true);
    assertThat(app.contact().count(),equalTo( before.size() + 1));
    Contacts after = app.contact().all();


    assertThat(after,
            equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }
}
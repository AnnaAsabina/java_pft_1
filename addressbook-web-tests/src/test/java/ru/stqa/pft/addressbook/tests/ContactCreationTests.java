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
   Contacts before = app.contact().all();
    app.contact().initContactCreation();
  ContactData contact = new ContactData().withFirstName("Annatest2").withMiddleName("Pvalovnatest").withLastName("Asabinatest").withAddress("Adresstest").withMobile("+7888888888888").witheMail("anna@test.test").withGroup("test1");
    app.contact().create(contact,true);
    Contacts after = app.contact().all();
    assertThat(after.size(),equalTo(before.size()+1));

    assertThat(after,
            equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }
}
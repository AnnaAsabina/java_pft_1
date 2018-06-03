package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test(enabled = true)

  public void contactCreationTests() {
    List<ContactData> before = app.contact().list();
    app.contact().initContactCreation();
  ContactData contact = new ContactData().withFirstName("Annatest2").withMiddleName("Pvalovnatest").withLastName("Asabinatest").withAddress("Adresstest").withMobile("+7888888888888").witheMail("anna@test.test").withGroup("test1");
    app.contact().create(contact,true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
         before.sort(byId);
          after.sort(byId);
         Assert.assertEquals(before, after);
  }
}
package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size()==0){
      app.contact().create(new ContactData().withFirstName("testFirstName1").withMiddleName("testMiddleName1").withLastName("testLastName1").withAddress("testAddress1").withMobile("+79797979797").witheMail("test@test.test").withGroup("test1"), true);
    }
  }

  @Test (enabled = true)
  public void testContactModification() {
    app.goTo().goToHomePage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId (before.get(index).getId()). withFirstName("Olga").withMiddleName( "Ivanovna").withLastName("Ivanova").withAddress("Kosmonavtov 26").withMobile( "336366363").witheMail("ivanova@test").withGroup(null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
         before.sort(byId);
          after.sort(byId);
          Assert.assertEquals(before, after);
  }



}
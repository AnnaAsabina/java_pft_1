package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData().withFirstName("testFirstName1").withMiddleName("testMiddleName1").withLastName("testLastName1").withAddress("testAddress1").withMobile("+79797979797").witheMail("test@test.test").withGroup("test1"), true);
    }
  }

  @Test (enabled = true)
  public void testContactModification() {
    app.goTo().goToHomePage();
    Contacts before = app.contact().all();
    ContactData modifiedContact =  before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()). withFirstName("Olga").withMiddleName( "Ivanovna").withLastName("Ivanova").withAddress("Kosmonavtov 26").withMobile( "336366363").witheMail("ivanova@test");
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo( before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
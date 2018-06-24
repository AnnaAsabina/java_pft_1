package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RemoveContactFromGroup extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("testName").withFooter("FooterTest").withHeader("HeaderTest"));
      groups = app.db().groups();
    }

    app.goTo().goToHomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Annatest2").withLastName("Asabinatest").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail1("email1").withEmail2("email2").withEmail3("email3").inGroup(groups.iterator().next()).withPhoto(new java.io.File("photo")), true);
    }
  }

  @Test
  public void testContactRemoveFromGroup() {
    Contacts contacts = app.db().contacts();
    Iterator<ContactData> iteratorContacts = contacts.iterator();
    ContactData contact = iteratorContacts.next();
    GroupData group = contact.getGroups().iterator().next();
    app.goTo().goToHomePage();

    while (iteratorContacts.hasNext()) {
      if (contact.getGroups().size() > 0) {
        group = contact.getGroups().iterator().next();
        app.contact().findGroupById(group.getId());
        break;
      } else {
        contact = iteratorContacts.next();
      }
    }
    app.contact().selectContactById(contact.getId());
    app.contact().removeContactFromGroup();
    app.goTo().selectGroupPage(group.getId());
    Groups groupsContactsAfter = app.db().contactById(contact.getId()).iterator().next().getGroups();

    assertThat(groupsContactsAfter, equalTo(contact.getGroups().without(group)));
  }
}




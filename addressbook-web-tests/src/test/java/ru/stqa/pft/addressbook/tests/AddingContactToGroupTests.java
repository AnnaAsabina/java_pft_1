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

public class AddingContactToGroupTests extends TestBase {


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
  public void testContactAddedToGroup() {

    Groups groupsInTheBeginning = app.db().groups();
    Contacts contactInTheBeginning = app.db().contacts();

    ContactData selectedContact = contactInTheBeginning.iterator().next();
    Groups groupSelectedContact = selectedContact.getGroups();

    GroupData selectedGroup;
    Iterator<ContactData> iteratorContacts = contactInTheBeginning.iterator();

    while (iteratorContacts.hasNext()) {
      if (groupSelectedContact.equals(groupsInTheBeginning)) {
        selectedContact = iteratorContacts.next();
        groupSelectedContact = selectedContact.getGroups();
      } else {
        break;
      }
    }
    if (groupSelectedContact.equals(groupsInTheBeginning)) {
      app.goTo().GroupPage();;
      app.group().create(new GroupData().withName("testName"));
    }
    groupsInTheBeginning = app.db().groups();
    groupSelectedContact = selectedContact.getGroups();
    groupsInTheBeginning.removeAll(groupSelectedContact);

    if (groupsInTheBeginning.size() > 0) {
      selectedGroup = groupsInTheBeginning.iterator().next();
    } else {
      throw new RuntimeException("no groups");
    }

    app.goTo().goToHomePage();
    app.contact().selectContactById(selectedContact.getId());
    app.contact().addInGroupById(selectedGroup.getId());
   app.goTo().selectGroupPage(selectedGroup.getId());

    ContactData contactAfter = app.db().contactById(selectedContact.getId()).iterator().next();
    Groups groupsContactAfter = contactAfter.getGroups();

    assertThat(groupsContactAfter, equalTo(groupSelectedContact.withAdded(selectedGroup)));

  }
}


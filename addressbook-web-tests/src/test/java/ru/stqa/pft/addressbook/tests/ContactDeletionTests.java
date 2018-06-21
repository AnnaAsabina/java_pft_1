package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    Groups groups = app.db().groups();

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("testName").withFooter("FooterTest").withHeader("HeaderTest"));
      groups = app.db().groups();
    }

    app.goTo().goToHomePage();
    if (app.db().contacts().size()==0){
      app.contact().create(new ContactData().withFirstName("Annatest2").withLastName("Asabinatest").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail1("email1").withEmail2("email2").withEmail3("email3").inGroup(groups.iterator().next()).withPhoto(new java.io.File("photo")), true);
    }
  }

  @Test (enabled = true)
  public void testContactDeletion() {
    app.goTo().goToHomePage();
    Contacts before = app.db().contacts();
    ContactData deletedContact =  before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(),equalTo( before.size() - 1));
    Contacts after = app.db().contacts();

    assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
    verifyContactsListUI();
  }

  }



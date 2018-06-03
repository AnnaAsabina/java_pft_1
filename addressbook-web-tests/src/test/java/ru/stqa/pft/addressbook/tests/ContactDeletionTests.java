package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData().withFirstName("testFirstName1").withMiddleName("testMiddleName1").withLastName("testLastName1").withAddress("testAddress1").withMobile("+79797979797").witheMail("test@test.test").withGroup("test1"), true);
    }
  }

  @Test (enabled = true)
  public void testContactDeletion() {
    app.goTo().goToHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact =  before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);

  }


}
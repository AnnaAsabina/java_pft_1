package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test(enabled = true)

  public void contactCreationTests() {
    app.goTo().goToHomePage();
    Contacts before = app.contact().all();
    app.contact().initContactCreation();
    File photo = new File("src/test/resources/flower.jpg");
    ContactData contact = new ContactData().withFirstName("Annatest2").withLastName("Asabinatest").withEmail1("email1").withEmail2("email2").withEmail3("email3").withAddress("Kosmonavtov26").withPhoto(photo).withGroup("test1")
          .withHomePhone("111").withMobilePhone("222").withWorkPhone("333");
    app.contact().create(contact,true);
    assertThat(app.contact().count(),equalTo( before.size() + 1));
    Contacts after = app.contact().all();


    assertThat(after,
            equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }

  @Test(enabled = true)
  public void testCurrentDir (){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/flower.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
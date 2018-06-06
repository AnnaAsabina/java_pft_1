
  package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

  public class ContactAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().goToHomePage();
      if (app.contact().all().size() == 0) {
        app.contact().create(new ContactData().withFirstName("Annatest2").withLastName("Asabinatest").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withAddress("Kosmonavtov26").withGroup("test1"), true);
      }
    }

    @Test
    public void testContactAdress(){
            app.goTo().goToHomePage();
             ContactData contact = app.contact().all().iterator().next();
          ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
          MatcherAssert.assertThat(contact.getAddress(), CoreMatchers.equalTo((contactInfoFromEditForm.getAddress())));
           System.out.println(contact.getAddress());
            System.out.println(contactInfoFromEditForm.getAddress());
         }

  }





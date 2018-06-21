package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;



public class ContactEmailTests extends TestBase {


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
      app.contact().create(new ContactData().withFirstName("Annatest2").withLastName("Asabinatest").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail1("email1").withEmail2("email2").withEmail3("email3").withAddress("Kosmonavtov26").inGroup(groups.iterator().next()), true);
    }
  }

  @Test
  public void testContactEmail(){
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    MatcherAssert.assertThat(contact.getAllEmails(), CoreMatchers.equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email){
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}




package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void homePage() {
    click(By.linkText("home"));
  }

  public void returnHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.geteMail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {

    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }




  public void creationContact(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact,true);
    submitContact();
    returnHomePage();
  }

  public boolean isContactExist() {
    return isElementPresent(By.name("selected[]"));
  }


  public int getContactCount() {
            return  wd.findElements(By.name("selected[]")).size();
       }




  public List<ContactData> getContactList() {
           List<ContactData> contacts = new ArrayList<ContactData>();
          List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
           for (WebElement element : elements){
                  String userLastname = element.findElement(By.xpath(".//td[2]")).getText();
                  String userName = element.findElement(By.xpath(".//td[3]")).getText();
                  ContactData contact = new ContactData(userName,userLastname,null,null,null,null,null);
                  contacts.add(contact);
             }
         return contacts;
        }
}
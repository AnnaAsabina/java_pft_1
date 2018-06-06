package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("work"),contactData.getWorkPhone());
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
    contactCache = null;
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }



  public void initContactModification(int index) {

    wd.findElement(By.xpath("//a[@href='edit.php?id="+ index +"']/img[@title='Edit']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }




  public void create(ContactData contact, boolean b) {

    initContactCreation();
    contactCache = null;
    fillContactForm(contact,true);
    submitContact();
    returnHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact,false);
    submitContactModification();
    contactCache = null;
    returnHomePage();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    closeAlert();
    contactCache = null;
    homePage();
  }




  public boolean isContactExist() {
    return isElementPresent(By.name("selected[]"));
  }


  public int count() {
    contactCache = null;
            return  wd.findElements(By.name("selected[]")).size();
       }


  private Contacts contactCache = null;

    public Contacts all() {
      if (contactCache != null) {
        return new Contacts(contactCache);
      }
      contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
      for (WebElement row: rows){
        List<WebElement> cells = row.findElements(By.tagName("td"));
        int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
        String firstname = cells.get(2).getText();
        String lastname = cells.get(1).getText();
        String allPhones = cells.get(5).getText();
        contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
                .withAllPhones(allPhones));
    }
      return new Contacts(contactCache);
  }


  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }


}
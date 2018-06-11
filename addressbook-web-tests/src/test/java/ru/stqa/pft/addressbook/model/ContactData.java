package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
@XStreamAlias("contact")
public class ContactData {

  @Expose
  private  String firstName;
  @XStreamOmitField
  private  String middleName;
  @Expose
  private  String lastName;
  private  String eMail;
  @Expose
  private  String group;

  private int id = Integer.MAX_VALUE;

  private int index;
  @XStreamOmitField
  private String allPhones;
  @Expose
  private String homePhone;
  @Expose
  private String mobilePhone;
  @Expose
  private String workPhone;
  private String allEmails;
  @Expose
  private String email1;
  @Expose
  private String email2;
  @Expose
  private String email3;
  private File photo;
  @Expose
  private String address;




  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }



  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }


  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }


  public ContactData withId(int id) { this.id = id;
    return this;}

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }




  public ContactData witheMail(String eMail) {
    this.eMail = eMail;
    return this;
  }



  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }


  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }


  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }




  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String geteMail() {
    return eMail;
  }

  public String getGroup() {
    return group;
  }

  public int getId() { return id; }

  public int getIndex() {
    return index;
  }

  public ContactData withIndex(int index) {
    this.index = index;
    return this;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }


  public String getEmail3() {
    return email3;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public File getPhoto() {
    return photo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }

  @Override
   public String toString() {
            return "ContactData{" +
            "id='" + id + '\'' +
                          ", firstName='" + firstName + '\'' +
                            ", lastName='" + lastName + '\'' +
                           '}';
       }



}

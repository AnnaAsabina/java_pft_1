package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String address;
  private final String mobile;
  private final String eMail;
  private final String group;

  public ContactData(String firstName, String middleName, String lastName, String address, String mobile, String eMail, String group) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.address = address;
    this.mobile = mobile;
    this.eMail = eMail;
    this.group = group;
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
    return mobile;
  }

  public String geteMail() {
    return eMail;
  }

  public String getGroup() {
    return group;
  }
}
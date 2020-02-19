package builder;

import java.time.LocalDate;

public class PersonBuilder {

  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private String addressOne;
  private String addressTwo;
  private String sex;
  private boolean driverLicence;
  private boolean married;

  public PersonBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public PersonBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public PersonBuilder setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public PersonBuilder setAddressOne(String addressOne) {
    this.addressOne = addressOne;
    return this;
  }

  public PersonBuilder setAddressTwo(String addressTwo) {
    this.addressTwo = addressTwo;
    return this;
  }

  public PersonBuilder setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public PersonBuilder setDriverLicence(boolean driverLicence) {
    this.driverLicence = driverLicence;
    return this;
  }

  public PersonBuilder setMarried(boolean married) {
    this.married = married;
    return this;
  }

  public Person build() {
    Person person = new Person();
    person.setFirstName(firstName);
    person.setLastName(lastName);
    person.setAddressOne(addressOne);
    person.setAddressTwo(addressTwo);
    person.setSex(sex);
    person.setDriverLicence(driverLicence);
    person.setMarried(married);
    return person;

  }
}

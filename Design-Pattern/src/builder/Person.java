package builder;

import java.time.LocalDate;

public class Person {

  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private String addressOne;
  private String addressTwo;
  private String sex;
  private boolean driverLicence;
  private boolean married;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getAddressOne() {
    return addressOne;
  }

  public String getAddressTwo() {
    return addressTwo;
  }

  public String getSex() {
    return sex;
  }

  public boolean isDriverLicence() {
    return driverLicence;
  }

  public boolean isMarried() {
    return married;
  }

  public Person setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Person setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Person setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public Person setAddressOne(String addressOne) {
    this.addressOne = addressOne;
    return this;
  }

  public Person setAddressTwo(String addressTwo) {
    this.addressTwo = addressTwo;
    return this;
  }

  public Person setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public Person setDriverLicence(boolean driverLicence) {
    this.driverLicence = driverLicence;
    return this;
  }

  public Person setMarried(boolean married) {
    this.married = married;
    return this;
  }

  public static PersonBuilder builder() {
    return new PersonBuilder();
  }
}

package builder;

import java.time.LocalDate;

public class TestPattern {

  public static void main(String[] args) {
    Person p1 = Person.builder()
        .setFirstName("이름")
        .setLastName("성")
        .setAddressOne("어딘가")
        .setAddressTwo("저긴가")
        .setBirthDate(LocalDate.now())
        .setSex("male")
        .setDriverLicence(false)
        .setMarried(true)
        .build();
    System.out.println(p1.getFirstName());
  }
}

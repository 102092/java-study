package com.inflearn.thejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

  public static void main(String[] args) {
    List<OnlineClass> springClasses = new ArrayList<>();
    springClasses.add(new OnlineClass(1, "spring boot", true));
    springClasses.add(new OnlineClass(2, "spring data jpa", true));
    springClasses.add(new OnlineClass(3, "spring mvc", false));
    springClasses.add(new OnlineClass(4, "spring core", false));
    springClasses.add(new OnlineClass(5, "rest api development", false));

    Optional<OnlineClass> spring = springClasses.stream()
        .filter(oc -> oc.getTitle().startsWith("spring")).findFirst();

    Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);
    System.out.println(progress.isEmpty());

  }

  private static OnlineClass createNewClass() {
    System.out.println("creating new class...");
    return new OnlineClass(10, "New Class", false);
  }
}

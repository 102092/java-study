package com.inflearn.thejava;

@FunctionalInterface
public interface RunSomething {

  int doIt(int number); // 추상 메서드

  static void printName() {
    System.out.println("Name");
  }

  default void printAge() {
    System.out.println("29");
  }

}

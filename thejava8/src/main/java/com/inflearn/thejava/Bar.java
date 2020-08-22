package com.inflearn.thejava;

public interface Bar {

  default void printNameUppercase() {
    System.out.println("BAR");
  }

}

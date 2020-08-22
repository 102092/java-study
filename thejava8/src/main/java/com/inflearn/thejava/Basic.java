package com.inflearn.thejava;

public interface Basic {

  default void a() {
    System.out.println("A");
  }

  default void b() {
    System.out.println("B");
  }

  default void c() {
    System.out.println("C");
  }

}

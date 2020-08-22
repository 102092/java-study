package com.inflearn.thejava;

public interface Foo {

  void printName();

  /**
   * @implSpec 이 구현체는 getName()으로 가져온 문자를 대문자로 바꿔 출력한다.
   */

  default void printNameUppercase() {
    System.out.println(getName().toUpperCase());
  }

  String getName();

  static void printAnything(){
    System.out.println("wow");
  }

}

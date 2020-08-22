package com.inflearn.thejava;

public class App {

  public static void main(String[] args) {
    Foo foo = new DefaultFoo("hello");
    foo.printName();
    foo.printNameUppercase();
    Foo.printAnything();
  }

}

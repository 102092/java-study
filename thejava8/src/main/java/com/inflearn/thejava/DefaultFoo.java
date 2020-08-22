package com.inflearn.thejava;

public class DefaultFoo implements Foo, Bar{
  String name;

  public DefaultFoo(String name) {
    this.name = name;
  }

  @Override
  public void printName() {
    System.out.println(this.name);
  }

  @Override
  public void printNameUppercase() {

  }

  @Override
  public String getName() {
    return this.name;
  }
}

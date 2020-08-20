package com.inflearn.thejava;

import java.util.function.Predicate;

public class Foo {

  public static void main(String[] args) {
    Predicate<String> start = (s) -> s.startsWith("han");
    Predicate<Integer> isOdd = (i) -> i % 2 == 1;
  }

}

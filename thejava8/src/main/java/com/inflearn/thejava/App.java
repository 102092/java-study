package com.inflearn.thejava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

  public static void main(String[] args) {
    List<String> fruits = new ArrayList<>();
    fruits.add("apple");
    fruits.add("banana");
    fruits.add("melon");
    fruits.add("orange");
    Comparator<String> comparator = String::compareToIgnoreCase;
    fruits.sort(comparator.reversed());
    fruits.forEach(System.out::println);
  }
}

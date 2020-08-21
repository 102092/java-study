package com.inflearn.thejava;

import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    String[] names = {"han", "hamil" ,"won", "huey"};
    Arrays.sort(names, String::compareToIgnoreCase); //임의의 인스턴스를 거쳐 가며, int값을 리턴함.
    System.out.println(Arrays.toString(names));
    //임의의 객체의 인스턴스를 참조한 것.

  }
}

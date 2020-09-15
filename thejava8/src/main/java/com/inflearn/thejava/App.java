package com.inflearn.thejava;

import java.util.Date;

public class App {

  public static void main(String[] args) throws InterruptedException {
      Date date = new Date();
      long time = date.getTime();

      Thread.sleep(1000 * 3);
      Date after3Seconds = new Date();
      System.out.println(after3Seconds);
      after3Seconds.setTime(time);
      System.out.println(after3Seconds);
  }
}

package com.inflearn.thejava;

import java.util.function.IntConsumer;

public class Foo {

  public static void main(String[] args) {
    Foo foo = new Foo();
    foo.run();
  }

  private void run() {
    final int baseNumber = 10;

    //로컬 클래스
    class LocalClass{
      void printBaseNumber() {
        int baseNumber = 11;
        System.out.println(baseNumber); // 11이 찍힘. 즉 로컬 클래스내 baseNumber가 로컬 변수인 baseNumber을 가리고 있다.
      }
    }

    IntConsumer intConsumer = new IntConsumer() {
      @Override
      public void accept(int baseNumber) { //매개변수로 들어간 baseNumber가 로컬 변수를 가린다.
        System.out.println(baseNumber); //익명 클래스에서 로컬 변수를 참조하고 있음.
      }
    };

    IntConsumer printInt = (i) -> {
      System.out.println(i); //람다에서 로컬 변수를 참조하고 있음.
    };
    printInt.accept(10);
  }

}

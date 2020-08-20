package com.inflearn.thejava;

public class Foo {

  public static void main(String[] args) {
    //익명 내부 클래스 anonymous inner class
    RunSomething runSomething = new RunSomething() {
      int baseNumber = 10;
      @Override
      public int doIt(int number) {
        return number + baseNumber;
      }
    };
    System.out.println(runSomething.doIt(1));
    System.out.println(runSomething.doIt(1));
    System.out.println(runSomething.doIt(1));
    System.out.println(runSomething.doIt(1));
    System.out.println(runSomething.doIt(1));
    System.out.println(runSomething.doIt(1));
    System.out.println(runSomething.doIt(1));


  }

}

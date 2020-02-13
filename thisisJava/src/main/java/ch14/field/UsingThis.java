package ch14.field;

public class UsingThis {

  public int field = 10;

  class Inner {

    int field = 20;

    void method() {
      MyFunctional myFunctional = () -> {
        System.out.println("outer :" + UsingThis.this.field);
        System.out.println("inner :" + field);
      };
      myFunctional.method();
    }

  }

}

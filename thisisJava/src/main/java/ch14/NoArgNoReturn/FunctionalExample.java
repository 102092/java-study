package ch14.NoArgNoReturn;

public class FunctionalExample {

  public static void main(String[] args) {
    MyFunctionalInterface mi;

    mi = () -> {
      String str = "method call1";
      System.out.println(str);
    };

    mi.method();

    mi = () -> System.out.println("method call2");

    mi.method();

  }

}

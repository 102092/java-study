package ch13.genericMethod;

public class CompareExample {

  public static void main(String[] args) {
    Pair<Integer, String> p1 = new Pair<>(1, "사과");
    Pair<Integer, String> p2 = new Pair<>(1, "사과");
    boolean result = Compare.compare(p1, p2);

    System.out.println(result);
  }

}

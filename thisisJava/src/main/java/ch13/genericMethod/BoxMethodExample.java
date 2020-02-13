package ch13.genericMethod;

public class BoxMethodExample {

  public static void main(String[] args) {
    Box<Integer> box = Util.boxing(100);
    int intValue = box.getT();
    System.out.println(intValue);

    Box<String> box1 = Util.boxing("홍길동");
    String strValue = box1.getT();
    System.out.println(strValue);
  }

}

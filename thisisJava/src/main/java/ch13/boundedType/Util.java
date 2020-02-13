package ch13.boundedType;

public class Util {

  public static <T extends Number> int compare(T t1, T t2) {
    //Number는 Java.lang 패키지에서 제공해주는 추상 패키지
    double v1 = t1.doubleValue();
    double v2 = t2.doubleValue();

    return Double.compare(v1, v2);
  }

}

package ch16.middleStream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStream {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    IntStream intStream = Arrays.stream(arr);

    intStream.asDoubleStream().forEach(d -> System.out.println(d));

    intStream = Arrays.stream(arr);
    intStream.boxed().forEach(obj -> System.out.println(obj.intValue()));
  }

}

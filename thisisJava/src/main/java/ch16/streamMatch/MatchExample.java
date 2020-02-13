package ch16.streamMatch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatchExample {

  public static void main(String[] args) {
    int[] arr = {2, 4, 6};
    IntStream intStream = Arrays.stream(arr);
    boolean result = intStream.allMatch(a -> a%2 == 0);
    System.out.println(result);

    intStream = Arrays.stream(arr);
    result = intStream.anyMatch(a -> a%3 == 0 );
    System.out.println(result);

    intStream = Arrays.stream(arr);
    result = intStream.noneMatch(a -> a%3 == 0 );
    System.out.println(result);

  }

}

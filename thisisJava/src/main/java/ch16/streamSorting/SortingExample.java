package ch16.streamSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SortingExample {

  public static void main(String[] args) {
    IntStream intStream = Arrays.stream(new int[]{5, 3, 2, 1, 4});
    intStream
        .sorted()
        .forEach(i -> System.out.println(i));

    System.out.println();

    intStream = Arrays.stream(new int[]{5, 3, 2, 1, 4});
    intStream
        .boxed()
        .sorted(Comparator.reverseOrder())
        .forEach(i -> System.out.println(i.intValue()));

  }

}

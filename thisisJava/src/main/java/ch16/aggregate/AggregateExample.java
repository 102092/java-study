package ch16.aggregate;

import java.util.Arrays;
import java.util.OptionalInt;

public class AggregateExample {

  public static void main(String[] args) {
    long count = Arrays.stream(new int[]{1,2,3,4,5})
        .filter(n-> n%2==0)
        .count();

    System.out.println(count);

    long sum = Arrays.stream(new int[]{1,2,3,4,5})
        .filter(a -> a%2==0)
        .sum();
    System.out.println(sum);

    int max = Arrays.stream(new int[]{1,2,3,4,5})
        .filter(a -> a%2==0)
        .max()
        .getAsInt();
    System.out.println(max);

    int min = Arrays.stream(new int[]{1,2,3,4,5})
        .filter(a -> a%3==0)
        .min()
        .getAsInt();
    System.out.println(min);

  }

}

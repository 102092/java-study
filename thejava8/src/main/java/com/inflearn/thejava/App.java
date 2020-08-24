package com.inflearn.thejava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
    List<OnlineClass> springClasses = new ArrayList<>();
    springClasses.add(new OnlineClass(1, "spring boot", true));
    springClasses.add(new OnlineClass(2, "spring data jpa", true));
    springClasses.add(new OnlineClass(3, "spring mvc", false));
    springClasses.add(new OnlineClass(4, "spring core", false));
    springClasses.add(new OnlineClass(5, "rest api development", false));

    System.out.println("spring 으로 시작하는 수업");
    List<OnlineClass> startWithSpring = springClasses.stream()
        .filter(c -> c.getTitle().startsWith("spring"))
        .collect(Collectors.toList());
    startWithSpring.stream().forEach(s -> System.out.println(s.getId() + " " + s.getTitle()));

    System.out.println("===============================");
    System.out.println("close 되지 않는 수업");
    springClasses.stream()
        .filter(Predicate.not(OnlineClass::isClosed))
        .forEach(s -> System.out.println(s.getId()));

    System.out.println("===============================");
    System.out.println("수업 이름만 모아서 스트림 만들기");
    List<String> spring = springClasses.stream().map(OnlineClass::getTitle)
        .collect(Collectors.toList());
    spring.forEach(System.out::println);

    List<OnlineClass> javaClasses = new ArrayList<>();
    javaClasses.add(new OnlineClass(1, "The Java Test", true));
    javaClasses.add(new OnlineClass(2, "The java Code manipulation", true));
    javaClasses.add(new OnlineClass(3, "THe Java 8 to 11", false));

    List<List<OnlineClass>> events = new ArrayList<>();
    events.add(springClasses);
    events.add(javaClasses);

    System.out.println("===============================");
    System.out.println("두 수업 목록에 들어있는 모든 수업 아이디를 출력");
    events.stream()
        .flatMap(Collection::stream)
        .forEach(oc -> System.out.println(oc.getId()));
    System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고, 최대 10개 까지만");
    Stream.iterate(10, i -> i + 1)
        .skip(10)
        .limit(10)
        .forEach(System.out::println);
    System.out.println("자바 수업 중에 Test가 들어있는 수어이 있는지 확인");
    boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
    System.out.println(test);

    System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 list로 만들기 ");
    List<String> springList = springClasses.stream().filter(oc -> oc.getTitle().contains("spring"))
        .map(OnlineClass::getTitle)
        .collect(Collectors.toList());
    springList.stream().forEach(System.out::println);
  }
}

# java-practice
> 참고

- https://github.com/code-squad/java-practice
- https://madplay.github.io/post/java-streams-intermediate-operations



## Lambda

- 익명함수의 다른 표현.
- Java에서 함수형 프로그래밍을 위한 방법.

- `@FuntionalInterface` 는 반드시 하나의 메서드만 가지고 있어야 한다.
  - 왜? 람다로 넘겨야 하니까.



## Stream

- filter

  - 중간 연산자.

  - 스트림을 통해, 중간에 뭔가 개발자가 원하는 연산이 들어가는 것.

  - 조건에 따라 걸러낼 때 사용. 

  - if문 사용하는 것과 비슷하다.

  - 매개변수로는 `Predictate<T>` 라는 인터페이스가 들어간다.

    - 개발자가 정의할 수 있음.
    - 익명객체를 통해, 혹은 인터페이스를 직접 만들어서.

  - 익명객체를 통해

    ```java
    list.stream().filter(new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.length() == 5;
        }
    });
    ```

- map

  - 중간연산자

  - 스트림을 통해, 개별요소에 뭔가 맵핑을 시켜주는 것.

  - 요소들의 형태를 변환하거나, 혹은 무언가 연결시켜줄수도 있는듯.

  - ex) MapToInt 

    ```java
    List<String> list = List.of("0", "1");
    IntStream intStream = list.stream()
            .mapToInt(value -> Integer.parseInt(value));
    intStream.forEach(System.out::println);
    ```

    - IntStream을 통해서, String을 Integer 로 변환 시켜주고 있음.

- reduce

  - 종단 연산자.
  - 스트림의 마지막에 행해지는 메서드
  - 음.. 차원을 줄여줄 때 사용.
  - 예를 들면, 배열의 합을 구한다. 이는 2차원적인 배열을 1차원으로 줄여준다고 생각해볼 수도 있음.

  - `reduce(0, (x,y) -> x+y);`
    - x==0, y는 스트림에서 뽑아지는 요소들. 이는 `sum()` 과 같은 결과를 나음.

- flatMap
  - 아직 까지 어떠한 역할을 하는 지 확실하게 설명하기가 힘듬.
  - 두루뭉실함.
  - Map의 역할에서 뭔가 변화가 되었기에 따로 이름을 받고 나왔겠지?
  - 거기에 flat이라는 뭔가 맵의 기능을 단순화 했기 때문이지 않을 까 예측함.
  - 중첩된 구조를 한단계 없애고, 단일 원소 스트림으로 진행되게 해준다..음..


# java-practice
> 참고

- https://github.com/code-squad/java-practice



## Lambda

- 익명함수의 다른 표현.
- Java에서 함수형 프로그래밍을 위한 방법.

- `@FuntionalInterface` 는 반드시 하나의 메서드만 가지고 있어야 한다.
  - 왜? 람다로 넘겨야 하니까.



## Stream

> 참고

- https://madplay.github.io/post/java-streams-intermediate-operations

#### filter

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

#### map

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

#### reduce

- 종단 연산자.
- 스트림의 마지막에 행해지는 메서드
- 음.. 차원을 줄여줄 때 사용.
- 예를 들면, 배열의 합을 구한다. 이는 2차원적인 배열을 1차원으로 줄여준다고 생각해볼 수도 있음.

- `reduce(0, (x,y) -> x+y);`
  - x==0, y는 스트림에서 뽑아지는 요소들. 이는 `sum()` 과 같은 결과를 나음.

#### flatMap

- 중간 연산자.

- 아직 까지 어떠한 역할을 하는 지 확실하게 설명하기가 힘듬.
- 두루뭉실함.
- Map의 역할에서 뭔가 변화가 되었기에 따로 이름을 받고 나왔겠지?
- 거기에 flat이라는 뭔가 맵의 기능을 단순화 했기 때문이지 않을 까 예측함.
- 중첩된 구조를 한단계 없애고, 단일 원소 스트림으로 진행되게 해준다..음..



## Optional

> 참고

- https://www.baeldung.com/java-optional
- 왜 Optional?
  - 널 오류를 내는 것보다, 차라리 Optional 이라는 객체에서 해결하도록 하는 것이 프로그램 진행에 덜 영향을 주는 것이어서?
- `isPresent()` 메서드는 Optional 객체 안에 값이 있는지 확인할 때 사용한다.
- `of()` 메서드를 통해 Optional 객체를 만들 수 있다.
  - 그렇지만 해당 메서드는 Null일 수 없기 때문에, NullPointerException이 발생할 수 도 있음.
  - 그래서 null이 들어올수도 있다고 예상될때는
  - `ofNullable()` 메서드를 통해 Optional 객체를 생성한다
  - 위와 같은 메서드를 통해 객체를 생성하면, 오류가 발생하지 않음.

- `isPresent()` , `isEmpty()` 는 같은 역할을 하는 메서드.

  - Optional 객체가 비어있나 안비어있나 확인하는.

- `ifPresent()` 메서드는 boolean 값을 리턴함.

  ```java
  public void givenOptional_whenIfPresentWorks_thenCorrect() {
      Optional<String> opt = Optional.of("baeldung");
      opt.ifPresent(name -> System.out.println(name.length()));
  }
  ```

  - 존재하면, 길이를 반환하라는 의미.
  - 코드 실행에 안전성을 더 가미하는 방법인듯.

- `orElse()`

  ```java
  public void whenOrElseWorks_thenCorrect() {
      String nullName = null;
      String name = Optional.ofNullable(nullName).orElse("john");
      assertEquals("john", name);
  }
  ```

  - null 객체가 왔을 경우, 기본적으로 할당될 값을 설정해주는 듯.

- `orElseGet()`

  ```java
  public void whenOrElseGetWorks_thenCorrect() {
      String nullName = null;
      String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
      assertEquals("john", name);
  }
  ```

  - `orElse()` 메서드와 비슷하지만, 값을 할당하는 대신에, return 하는듯?

  - 차이점이 있다면,

    ```java
    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
    
    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;
     
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);
     
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
    }
    ```

    - 이 코드에는 사이드 이펙트가 있음
    - 어떤거? `System.out.println("Getting Default Value");` 이부분
    - 만약에 할당된 값이 `null` 이라면 두 개의 메서드는 동일하게 움직임.
    - 그렇지만

    ```java
    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
    
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text present";
     
        System.out.println("Using orElseGet:");
        String defaultText 
          = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text present", defaultText);
     
        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text present", defaultText);
    }
    
    /*
    Using orElseGet:
    Using orElse:
    Getting default value...
    */
    ```

    - `orElseGet` 은 side effect 가 실행되지 않고, 바로 return 으로 간듯?
    - `orElse()` 는 기본적인 객체가 생성되었고, 그래서 side-effect가 발생하는 것을 볼 수 있음.
    - 이러한 객체를 생성하는데 엄청난 자원이 들진 않지만, *웹서비스를 부를 때나 DB에 쿼리로 접근할 때는 비용이 매우 중요해지므로, 어떤 메서드를 쓸지는 반드시 체크해야할 부분인듯*.

- `orElseThrow()`

  - 값이 null이면 오류를 던짐.

- `get()`

  - 값에 접근하는 마지막 방법. 
  - 아마도 Optional 메서드 중에 가장 마지막에 나오지 않을까.
  - 반드시 값을 리턴해야하기 때문에, 만약에 Optional로 포장된 것이 Null 이라면 오류를 발생시킬 것. NoSuchElementException

  ```java
  public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
      Optional<String> opt = Optional.ofNullable(null);
      String name = opt.get();
  }
  ```

- `filter` 를 사용해서 조건에 맞는 값만 리턴해주도록 해줄 수도 있는듯.

  ```java
  public void whenOptionalFilterWorks_thenCorrect() {
      Integer year = 2016;
      Optional<Integer> yearOptional = Optional.of(year);
      boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
      assertTrue(is2016);
      boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
      assertFalse(is2017);
  }
  ```

  - 만약에 Optional에 담긴 값이, 조건상 맞지 않는다면, 아마도 Empty Optional을 return 해줌.
  - 왜? filter는 미리 정의된 규칙을 기반으로 미리 판단하기 때문.
  - map은 원래 value를 수정하는 것이 아니다.

- `map()` 을 사용하여 값을 변화(원래값은아니고) 시킬 수 있음.

- `flatMap()` 을 사용하여, 변환시킬 수 있음.

  - 맵은 변환하기 전에 값들이 포장되어 있지 않을 때 변환시킬 수 있지만
  - flatMap은 포장된 값을 가질 수 있고, 그리고 풀 수도 있음 변환하기 전에 
    - 약간 귀찮은 단계를 하나 줄여준 기분.

  
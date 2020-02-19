## 참고

- https://www.youtube.com/watch?v=Sos11X7wy1M&list=PLVsNizTWUw7FPokuK8Cmlt72DQEt7hKZu


## 목표

- 유투브 강의를 기반으로, 부족했던 `Java` 개념 복습
- 강의 예제 코드를 그대로 써보고 어떻게 돌아가는지 주석 및 `README.md` 파일 갱신



## Ch12

- 멀티 스레드? 
  
    - 하나의 프로세스 안에, 여러개의 스레드가 생성되어서 동시에 코드를 실행하는 것.
    
- main 스레드
    - JVM 에 의해서 생성됨.
    - 다른 스레드들은, main 스레드로 부터 파생된다. 이 말은 제일 처음 생성되는 스레드는 main 스레드.
    
- Thread 를 생성하는 방법은?
    1. Thread class 로 부터
    2. Thread class 하위 클래스로 부터
    - 어떤 차이가 있을까?
    - 1) `Runnable` 인터페이스를 구현하여, Thread 인스턴스를 만들어서, `.start()` 함.
    - 2) `Thread` 객체를 상속받아, extends 통해 확장 구현하는 느낌.
        - 이렇게 상속받았기에, 바로 `start()` 를 실행시킬수 있음.
    
- 메인 스레드 이름은 main
  
    - 작업 스레드는 Thread-n~ 이라고 나옴.
    
- `Thread.currentThread();` 해당 코드를 실행하는 스레드의 참조를 얻는 방법.
  
    - 해당 스레드의 인스턴스를 통해 알수 있겠네
    
- `thread.start()` 는 반드시 한번만 실행할 수 있다.

- 동시성
  - 하나의 코어에서 멀티 스레드가 번갈아가면서 실행하는 성질을 일컫는 말.
  - 한번에 하나의 스레드만 작동한다.
  
- 병렬성
  - 멀티 작업을 위해서 멀티 코어에서 개별 스레드가 동시에 실행하는 성질
  - 한번에 몇몇의 스레드가 실행된다.
  
- 스레드 스케쥴링
  - 왜? 여러개의 스레드가 대기중일 때, 어떻게 번갈아가면서 실행시킬 것인가?를 결정해야하니까
  - 동시성과 관련된 문제.

- 공유객체

  - 두개의 스레드가 하나의 객체를 공유해서 사용할 경우에, 문제가 발생하지 않을까?

- `synchronzied`

  - 단 하나의 메서드만 접근할 수 있는 조건을 선언해주는 방법

  ```java
  public synchronized void method(){
    //단 하나의 스레드만 실행할 수 있는 메서드
  }
  ```

- 스레드

    - Runnable? 실행 대기 상태
    - WAITING, TIME_WAITING, BLOCKED 일시정지 상태
    - NEW 객체가 생성된 상태이고 아직 start가 안되었음.
    - TERMINATED 실행을 마친 상태, 아직 스레드가 닫히진 않았다. 텀이 있음.

- 상태제어

  ![](https://t1.daumcdn.net/cfile/tistory/2135CD42566BC7D825)

  - `stop` 사용하지 말라. 왜? 자원정리가 미미할 수 있다. deprecated된 메서드임.
  - `yield` 다른 스레드에게 실행을 양보할 때 사용됨.
  - `join` 다른 스레드의 종료를 기다린다.

- 스레드간 협업
  - `동기화 메서드(synchronzied)`나, `블록`에서만 호출해야한다. 왜? 한번에 한 스레드만 접근하도록 하려구
  - wait, notify, notifyAll
  - wait 호출한 해당 스레드는 일시정지상태로 감
    - 다른 스레드가 notify or notifyAll을 해야만 일시정지 상태가 풀림
    - 혹은 옵션을 다르게 주던가.
  - 어디에 사용? 공유객체를 여러 스레드에서 접근해야 할때.
  - `Interrupt` 다른 스레들에게 예외를 발생하라고 이야기 해줌. 실행대기 상태로 가라고
    - 다만 InterruptedException이 발생하려면 반드시 해당 스레드는 **일시정지 상태**여야 한다.

- 데몬스레드
  - 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드.
  - ex) GC, 가비지 컬렉터
  - JVM이 실행될때만 가비지 컬렉터가 실행되므로.
  - 주 스레드가 설정하는 것.
    - 반드시 해당 데몬스레드가 실행되기 전에 설정해야 한다.

- 스레드 그룹
  - 어떤 스레드든 하나의 스레드 그룹에 포함된다.
  - 기본적으로는 자신을 생성한 스레드와 같은 그룹에 포함됨.
  - 스레드 그룹을 만들어서, 만든 스레드를 명시적으로 포함시킬 수 있게된다.
  - 특징은,
    - 스레드 그룹에서 interrupt()를 호출하면, 포함된 모든 스레드의 interrupt()가 호출됨.
    - 언제?
    - 스레드 그룹에 있는 모든 스레드를 종료할 필요가 있을때.

- 스레드 풀(ExecutorService)

  - 스레드가 마구마구 뛰어노는 풀장 같은 느낌.
  - ExecutorService의 객체임

  ![](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F231B374B595F67F43A2190)

  - 최대 생성 스레드는, 운영체제 상황에 따라 달라짐.
  - 어떻게 생성되냐에 따라서, 해당 스레드가 종료되더라도 남아있을 수도, 아니면 삭제될 수 도 있네.
  - 스레드 풀의 스레드는 기본적으로 데몬 스레드가 아니므로, **종료** 시켜야한다.
    - `shutdown` 으로
  - 스레드 풀 작업 큐에 들어갈 객체는 `Runnable ` or `Callable` 
    - 차이? 처리 완료 후  `return` 값이 있냐 없냐의 차이
  - 작업을 넣을 때는 `submit`으로 
    - 왜? 해당 스레드를 재사용하므로 좀 더 효율적
  - `submit` 은 `Future` 라는 객체를 리턴 받는다.
    - 왜 Future? 그 즉시 내용을 받음. 아직 스레드에서 처리가 되지 않았는데도 불구하고.
    - 지연되어서 나온다고 해서, *지연객체*라고도 함.
    - 해당 작업이 완료되면 값을 얻기 위해 `get()` 메서드를 사용
    - 블로킹되어있음. 블로킹? 작업이 완료될때까지, 접근할 수 없음.
  - `Future`  `get`은 UI 스레드에서 호출하면 안된다.





## ch13

#### 제네릭

- 왜 사용?

  - 컴파일시, 미리 타입을 지정하여 원하는 타입인지 체크할 수 있다는 이점.
  - 즉 오류 발생을 줄여준다.
  - 그리고 타입변환을 제거할 수 있음.

  ```java
  List list = new ArrayList();
  list.add("hello");
  String str = (String) list.get(0);
  
  //위에 것을 아래것으로 가능 제네릭을 사용해서
  
  List<String> list = new ArrayList<String>();
  list.add("hello");
  String str = list.get(0);
  ```

  - 왜 타입 변환을 하면 안될까?
    - 타입 변환은 부담을 준다. 

- 제네릭은 *클래스*, *인터페이스* 에 모두 사용할 수 있다.

  ```java
  class Example<Obejct> {}
  ```

  - 일반적으로 타입을 명시하지 않으면 `Object` 

  ```java
  public class Box<T>{
    private T t;
    public T get() {return t;}
    public void set(T t) {this.t = t;}
  }
  ```

  - T ?
    - Box 클래스에 어떤 타입이 들어올지 모르기 때문에, Type parameter로 선언해준 것.
    - 이 타입은 string등등의 타입이 들어갈 수 있음.



#### 멀티 타입 파라메터

- 두 개 이상 타입 파라미터를 사용할 수 있음.
  - `class <K, V,...> ....{...}`
  - `interface <K, V,...> .... { ..... }`

- T == type
- M == Model



#### 제네릭 메소드

- 매개변수 타입과 리턴 타입으로 *타입 파라미터*를 갖는 메소드

  ```java
  public <T> Box <T> boxing(T t){...} // 제네릭 메서드
  
  Box<Integer> box = <Integer> boxing(100); //명시적으로 타입 파라미터 선언
  Box<Integer> box = boxing(100); // 컴파일러가 알아서 유추함.
  ```

  

#### 제한된 타입 파라미터

- 상속 및 구현 관계를 이용할 때 타입을 제한하는 방법
- public <T extends 상위타입> 
  - 상위타입은 클래스, 인터페이스도 가능.
  - 클래스의 타입혹은 자식이 올 수 있고,
  - 인터페이스라면 인터페이스 구현객체가 올 수 있음.

```java
public <T extends Number> int compare(T t1, T t2){
  // T는 Number 클래스거나 Number 클래스의 하위 클래스
  // 이것을 구현하는 바디 부분은, Number 만 가지고 있는 메소드, 필드 변수만 사용할 수 있음.
  // 즉 Number의 자식 클래스 만이 독특하게 가지고 있는 메소드, 필드 변수는 사용할 수 없음.
  double v1 = t1.doubleValue();
  double v2 = t2.doubleValue();
}
```



#### 와일드 카드 타입

- 이미 선언된 제네릭 타입 파라미터를 제한할 목적으로 사용

- 세가지 경우

  - A(상위) <- B <- C <- D <- E(하위)

  1. `?`

     - 제한 없음.

  2. `? extends`

     - ex ? extneds C : C, D, E 만

     - 상위 클래스의 하위 클래스만 들어갈 수 있음.

  3. `? super`

     - ex> super C : A, B , C

     - 하위 클래스의 위쪽 부분만 올 수 있음.

- 예제 코드

  ```java
  package ch13.wildcard;
  
  public class WildCardExample {
  
    public static void registerCourse(Course<?> course) { }
    public static void registerCourseStudent(Course<? extends Student> course) {
      //? extends Students
      // Students를 확장하는 클래스만 올 수 있음.
      // 즉 Students 자체와, 이를 상속받은 HighStudents만
    }
    public static void registerCourseWorker(Course<? super Student> course) {
      //? super Worker
      // Student 가 제일 하위 클래스
      // 즉 Student를 상속받았거나(High student) 전혀 상관없는 Worker 객체는 받을 수 없음.
    }
  
  
  
    public static void main(String[] args) {
      registerCourse(new Course<Person>("일반인 과정",5));
      registerCourse(new Course<Worker>("근로자 과정",5));
      registerCourse(new Course<Student>("학생 과정",5));
      registerCourse(new Course<HighStudent>("고등학생 과정",5));
  
  //    registerCourseStudent(new Course<Person>("일반인 과정",5)); 오류
  //    registerCourseStudent(new Course<Worker>("근로자 과정",5)); 오류
      registerCourseStudent(new Course<Student>("학생 과정",5));
      registerCourseStudent(new Course<HighStudent>("고등학생 과정",5));
  
      registerCourseWorker(new Course<Person>("일반인 과정",5));
      //registerCourseWorker(new Course<Worker>("근로자 과정",5)); 오류
      registerCourseWorker(new Course<Student>("학생 과정",5));
      //registerCourseWorker(new Course<HighStudent>("고등학생 과정",5)); 오류
    }
  }
  ```

  

## ch14

#### 함수형 프로그래밍

- 데이터를 매개값으로 전달하고, 결과를 받는 형식.
- 대용량 데이터를 처리시 에 유리.
  - 왜? 데이터를 객체로 만들어서 처리하기보다는, 그냥 그대로 처리하는게 빠름.
- 이벤트 지향 프로그래밍에 적합.
  - 핸들러 객체보다는, 핸들러 함수가 적합하다.
- 자바에서 함수형은?

  - 람다.
- 람다를 사용해서 **코드를 좀 더 간결**하게.
- 혹은 **익명함수를 생성하기 위해서** 람다를 사용



#### 기본적인 람다식

  `(int a) -> {System.out.println(a);}`

  - 매개변수가 하나라면 괄호 생략 가능

    `a -> {System.out.println(a);}`

  - 그렇지만 매개변수가 없으면 생략할 수 없음.

    `() -> {System....}`

- `@FunctionalInterface `
  - 하나의 추상 메서드만을 가지는 지 컴파일러가 체크
    - 두개 이상이면 오류
  - 왜? 인터페이스를 작성할 때 실수를 줄이기 위해서.

- 람다식에서 사용하는 외부 로컬 변수는 `final` 특성을 가진다.
  
  - 왜? 람다식은 익명 구현 객체를 생성하기 때문에.



#### 표준 API의 함수적 인터페이스

- 하나의 추상 메서드를 가지는 인터페이스는 모두 람다식이 사용 가능함.

![](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile28.uf.tistory.com%2Fimage%2F99D232335A2109D823BB84)

- 5가지 종류가 있음.
  - Java.util.function 의 Interface들의 접미사에 붙어있음.



#### 메소드 참조

- 람다식에서 불필요한 매개변수를 제거하는 것이 목적.

- 익명 구현 객체로 생성됨.

  - 그러므로 메서드 참조를, 인터페이스에 대입할 수 있음.

    `IntBinaryOperator operator = Math::max;`

- 정적 메소드 , 인스턴스 메소드 참조에 따라 작성 방법이 다름.

  ```java
  public class Calculator {
    public static int staticMethod(int x, int y) {
      return x + y;
    }
    
    public int instanceMethod(int x, int y) {
      return x + y;
    }
  }
  
  // 정적 메소드 참조
  operator = (x, y) -> Calculator.staticMehod(x,y);
  operator = Calculator::staticMehod;
  
  //인스턴스
  Calculator obj = new Calculator();
  operator = (x, y) -> obj.instanceMethod(x, y);
  operator = obj::instanceMethod;
  ```

- 매개 변수의 메서드 참조

  `(a,b) -> {a.instanceMethod(b);}`  ==> `클래스 :: instanceMethod` 

  - 클래스는 a의 타입에 따라 달라짐.

- 생성자 참조

  `(a,b) -> {return new 클래스(a,b); }` ==> `클래스 :: new`

  - 클래스라는 객체를 생성하겠다는 의미에 생성자 참조.
- 클래스 객체 중에서 a type을 매개변수로 받는 생성자를 호출하게 됨.



## ch16



#### 스트림 파이프라인

- 스트림이 진행되는 도중에, 라인을 하나 더 만들어서 무언가 개발자가 원하는 연산이 처리될 수 있도록 해주는 것.

- 중간 처리 메소드, 최종 처리 메서드
  - 어떤 차이?
  - 중간 처리는 리턴 타입이 스트림
  - 최종 처리는 리턴을 기본 타입 혹은 Optional

#### 중간처리

- 최종처리 메서드가 호출되지 않으면 지연되기 때문에, 최종처리 메서드가 반드시 필요하다.

- 필터링을 담당하는 메서드는 
  - `distinct()` -- 아마 중복 제거
  - `filter()` -- 조건에 맞는 것만.
- 맵핑
  - 스트림의 요소를 다른 요소로 대체하는 것을 일컫음.
  - 하나의 요소가 여러개의 요소로 대체 될 수 있음.
    - 반드시 1:1 맵핑되어야 되는 것은 아님.
  - `flatMapXXX()` -- 한 개의 요소를 복수 개의 요소로 대체 1: 다
  - `mapXXX()` -- 한 개의 요소를 하나의 요소로 대체. 1:1  

- 정렬 - sorted

  - Double, Int, Long Stream 은 기본적으로 올림차순.

  - 객체를 정렬해야할 경우, `Comparable` 를 구현해야 정렬이 가능함.

    - 그러지 않을 경우? `ClassCastException` 이 발생

  - Comparator 이용하는 방법도 있는데

  - 예시

    ```java
    //기본비교
    sorted();
    sorted(a,b -> a.compareTo(b));
    sorted(Comparator.naturalOrder());
    
    
    //기본비교 방법과 정반대가 필요할 때;
    sorted((a,b) -> b.compareTo(a));
    sorted(Comparator.reverseOrder());
    ```

  - ComparaTo는 int 값을 리턴함. 음,0,양수

    ```java
    public int comparaTo(Studnet o){
      return Integer.compare(score, o.score);
      //언제 음수? score < o.score
      //0 score == o.score
      //양수 score > o.score
    }
    ```

    ```java
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
    ```

- 루핑 -- looping

  - 중간 처리, 최종 처리 모두에서 가능.
  - 중간처리 : `peek()`
    - 중간처리 메서드이기 때문에, 반드시 최종 처리 가 필요함

  - 최종처리 : `forEach()`

#### 최종 처리

- 매칭 -- Matching
  - 3종류 있음.
    1. `allMatch()`
       - 모두 조건에 만족해야됨. 스트림에 있는 요소들이
    2. `anyMatch()`
       - 최소한 한 개의 요소가 조건에 만족해야되고
    3. `noneMatch()`
       - 어떠한 요소들도 조건에 만족해서는 안됨.
  - Return 은 boolean type
- 집계 -- Aggregate
  - 카운팅, 합계 , 평균, 최소, 최대
  - Reduction 대량이 데이터를 가공해서 축소하는 일컫음.
  - 이렇게 진행되는 값은 `Optional` 클래스로 받음.

- reduce()
  
- 개발자가 뭔가 특정 집계 결과물을 만들 수있게 지원해주는 메서드
  
- collect() -- 수집

  - 스트림에 속한 요소들을 그룹핑하는 것

    - 그룹핑을 하면 Map 객체로 리턴해줌

  - 새로운 컬렉션으로 만들어내는것.

  - 그룹핑을 통해, 집계 할 수 있음.

  - Collector 타입 파라미터

    - T  : 요소
    - A : accumulator
    - R  : 요소가 저장될 새로운 컬렉션

    ```java
    List<Student> maleList = totalList.stream()
      .filter(s-> s.getSex() == Student.Set.Male)
      .collect(Collectors.toList());
    
    Set<Student> femaleSet = totalList.stream()
      .filter(s-> s.getSex() == Student.Sex.FEMALE)
      .collect(Collectors.toCollection(HashSet::New));
    ```

    

  - 그룹핑 수집
    1. `Collectors.groupingBy();`
       - 스레드에 안전하지 않는 
    2. `Collectors.groupingByConcurrent();`
       - 스레드에 안전함.

#### 병렬 처리

- 하나의 task를 분할해서 동시에 처리하는 것.
  - 왜? 작업 처리 시간을 줄여줌.
- 병렬 스트림을 통해서 처리함.
- 동시성 : 여러개의 작업들을 하나의 코어에서 번걸아 가며 실행함.
- 병렬성 : 여러개의 코어에서 다수의 작업들이 병렬적으로 실행됨.
  - 데이터 병렬성 : 데이터가 분할되어서 
  - 작업 병렬성 : 서로 다른 작업을 병렬 처리.
    - 예시 : 웹서버
  - 병렬 스트림은, 데이터 병렬성을 구현한 것.

- 병렬 스트림은 forkjoin framework를 사용함.
  - 포크 : 데이터를 서브 데이터로 분리.
  - 조인 : 서브 결과를 결합해서, 결과를 만들어냄.

- 병렬 처리가 항상 빠르지는 않음.
  - 왜? 요소의 수, 어떤 스트림을 사용하는지, 해당 컴퓨터의 코어는 얼마나 되는지에 따라 영향을 받을 수 있음.
  - 스레드를 새로 생성하는 것은, 혹은 스레드 풀을 생성하는 것은 꽤 많은 컴퓨터의 자원을 소모하는 일임.

## ch17

- AWT
  
  - Abstract Window Toolkit
- Swing
  - 모든 운영체제에서 동일한 UI를 갖도록
  - AWT를 개선함.
  - 별로 많이 사용 안됨
  - 왜? 컴퓨터의 리소스를 많이 소모해서.

- Java FX

  - Swing을 개선
  - Swing은 자바 코드로 모두 개발해야 하는 반면, FX는 기능(레이아웃, 스타일, 애플리케이션 로직)을 분리개발함.

  



## ch18

- I/O
  
  - Input, Output
  
  ![](https://lh3.googleusercontent.com/proxy/7OwdaGvVJBNmGjH9Dx_zPKAZAbFrySvUxSlPj2E9pe_pyNwTaY8DB9mVAMsNXsooq0tiOGAGD7HQl_mZkQ)

- `InputStream` 은 추상 클래스.
  - 즉 객체를 생성할 수 없음.
  - `read()` 더 이상 읽을 것이 없으면 -1 을 리턴함.
- 키보드로부터 읽는 것은 아스키 코드.
- `OutputStream` 은 추상 클래스
- `flush() ` 버퍼를 모두 비운다
  - 무언가 받거나, 쓰는 작업을 하면 사용한 버퍼를 비워주는 것이 좋음.
  - 그리고 해당 객체를 닫아주는 자원을 회수해주는 작업이 필요.

- 아스키 코드

  ![](https://t1.daumcdn.net/cfile/tistory/01539150511C961520)

- Scanner 클래스는 *문자열 외의 기본형 타입의 값도 읽을 수 있음.*
  
  - 다만 성능상 별로임. buffered..이런 종류의 애들보다는.



#### 파일 입출력

- 디렉토리도 생성,삭제하는 등의 관리하는 기능도 가지고 있음.

- 디렉토리 안에 있는 파일 리스트 값도 받아올수 있고.

- 영어리는 1byte, 한글은 2byte

- PrintStream은 OutputStream의 하위 스트림.

- 97은 == a

  ```java
  byte b = 97;
  os.write(b);  //a가 출력됨.
  os.flush();
  ```

- 개행문자 == 줄바꿈문자 `\r\n` 



#### 보조스트림

- 다른 스트림과 연결, 여러 기능들을 제공함.

- 문자를 받거나, 출력할 때는, 바이트 기반 스트림 보다는 문자기반 스트림을 사용하는 것이 더 유리하고 편함.

- Inputstream to `Reader` to 문자를 읽게 해줌.

  - 리더는 바이트로 들어온 input을 변환시켜줌.

  ```java
  InputStream is = System.in;
  Reader reader = new InputStreamReader(is);
  
  FileInputStream fis = new FileInputStream(...);
  Reader reader = new InputStreamReader(fis);
  ```

  

- Buffer를 이용한 스트림 활용.

  - 프로그램이 입출력 소스와 직접 소통하지 않고, `버퍼` 를 두어서, 좀 더 안정적으로 그리고 빠르게 데이터를 전송하고, 전송받는 방법.
  - 왜 이걸 사용?
    - 프로그램은 쓰기 속도가 향상되고,
    - 버퍼가 다 차면, 데이터를 **한번에** 보내주니까, 출력횟수가 줄어듬 == 과부하가 덜됨.

  ```java
  InputStream is = System.in;
  Reader reader = new InputStreamReader(is);
  BufferedReader br = new BufferedReader(reader);
  ```

  - 각각 스트림을 연결하여서 input 기능을 수행하고 있음.



- 객체 입출력 보조 스트림

  - 객체를 파일, 네트워크로 입출력할 수 있는 기능.

  ```java
  ObjectInputStream ois = new ObjectInputStream(바이트 입력 스트림);
  ObjectOutputStream oos = new ObjectOutputStream(바이트 출력 스트림);
  oos.writeObject(객체);
  
  ```

  - 직렬화? 객체를 바이트 배열로 만드는 작업을 만듬.
  - 역직렬화 ? 바이트 배열을 객체로 만드는 작업

- 직렬화가 가능한 클래스?

  - Serializable interface를 구현한 클래스만 직렬화 할 수 있음.

  - transient 키워드가 붙은 필드는 직렬화에서 제외된다.

  - serial/VersionUID 

    - 왜 사용?
    - 직렬화 된 객체를 역직렬화 할때는, 직렬화 했을 때와 같은 클래스를 사용함.
    - 클래스 이름이 같더라도, 해당 클래스 내용이 변경된 경우에는 역직렬화 실패.
    - 이와 같은 변경사항을 알려주기 위해 사용하는 시리얼 코드
    - 만약 변경사항이 있으면 해당 시리얼 코드를 명시적으로 선언해줘야한다.

- 포트

  - 클라이언트 서버에 연결할 때, 우선 IP를 통해서, 그리고 서버 컴퓨터 내부에서 어떤 프로그램과 연결할지 결정해야 하는데, 이 때 포트 번호를 통해 접근함.
    - 웹서버에 접근하려면 80번 포트
    - FTP서버는 21번 포트
    - DBMS는 1521 포트 등 약속된 포트 있긴 함.
  - 0~1023 : 미리 예약한 포트들
  - 1024~49151 : 회사에서 등록해서 사용할 수 있음.
  - 49152~65535 : 운영체제가 부여하거나, 혹은 개인적으로 설정할 수 있는 포트 범위



#### TCP

- 연결 지향적 --> 처음 연결하기 위해서는 다소 시간 소모.
- 3 hands shaking..

- 스레드 병렬 처리

  - 블로킹 된다 : 대기 상태가 된다.

    - ServerSocket의 accept()
    - Socket 생성자 또는 connect()
    - Socket read(), write()

  - 즉 다른 작업을 못한다.

  - 단 UI 생성, 변경 스레드에서는 블로킹 메서드를 호출하지 마라. 

    - 왜? UI 생성, 변경 안되고, 이벤트 처리도 안됨.

  - 무한적으로 스레드를 만들게 되면, 서버에 엄청난 부담

  - 즉 스레드 풀을 통해, 제한적인 스레드를 생성하도록 설정.

    ```java
    ExecutorSevice excutorService = Excutors.newFixedThreadPool(
      Runtime.getRuntime().availableProcessors()
    );
    ```

    - 프로세그가 감당할 수 있는 만큼의 스레드를 가지고 있는 스레드 풀을 생성한다.



#### UDP

- 비연결 지향적 --> 연결을 위한 절차가 없음. 그러므로 빠르게 데이터 전송가능.
- 그러면, 데이터 손실이 발생할 수 있음. 
  - 왜? 상대방과 연결이 되지 않은 채로 데이터를 보내기 때문에.
- `DatagramSocket` 을 사용.





### ch19



#### NIO

- New Input/Output
  - 채널 방식 : 하나의 채널로, 데이터를 읽고 쓸 수 있음.
    - cf 스트림은, 데이터 방향이 단방향
  - 버퍼 사용 : 무조건 버퍼에서 읽고, 버퍼에서 쓴
    - cf I/O non-buffer
      - 그래서 보조 스트림을 통해서 buffer를 제공했음. buffer를 이용하면 속도도 빨라졌고
  - 동기 / 비동기 방식을 모두 지원
    - cf I/O 는 무조건 동기
  - 블로킹 / 넌블로킹 모두 지원
    - cf I/O 무조건 블로킹
- 블로킹?
  - 어떤 작업을 할 때, 그 작업이 끝날 때 까지 기다리는 것을 의미함.
  - 블로킹 상태에 있는 스레드에 interrupt하더라도, 해당 블로킹 상태를 빠져나올 수 없음.
  - 블로킹된 상태를 빠져나오는 유일한 방법은, 스트림을 닫는 것.

- 언제 I/O?
  - 대용량, 순차적
- 언제 NIO?
  - 저용량, 입출력 작업이 빨리 끝날 때



#### 파일, 디렉토리

- `../` 현재 위치에서 상위로.
- 운영체제의 파일 시스템은, FileSystem 인터페이스를 통해서 접근.

- `WatchService` 디렉토리의 내용 변화를 감지하는 인터페이스.

  - `WatchService watchService = FileSystems.getDefault().newWatchService();`

  

#### 버퍼

- 읽고 쓰기 가능한 메모리 배열

- NIO는 항상 버퍼를 사용

- 종류는 *저장되는 타입*에 따라, *어떤 메모리를 사용하느냐에 따라*

- Non direct buffer
  - JVM이 관리하는 heap memory를 사용하는 버퍼
  - 생성 시간이 빠르지만, 버퍼 크기를 설정할 수 없는 단점이 있음.
  - 그리고 버퍼 크기도 작고
  
- Direct buffer
  - 운영체제가 관리하는 메모리를 사용하는 버퍼
  - 생성시간이 느리지만, 대용량 버퍼를 생성할 수 있음.
  - 생성시간이 느리기 때문에, 한번 생성해놓고 재사용하는 것이 유리

- Buffer 생성

  - Non direct buffer

    ```java
    ByteBuffer byteBuffer = ByteBuffer.allocate(int capacity)
    ```

  - 혹은 wrap()을 통해서, 이미 생성된 배열을 버퍼로 생성할 수 도 있음.
  
  - Direct buffer
  
    ```java
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(int capacity)
    ```
  
- ByteOrder

  1. Big endian .. 앞 바이트부터 처리
  2. Little endian .. 뒤 바이트 부터 처리

- <u>JVM은 무조건 Big endian</u>



#### 파일 채널

- FileChannel

  - 파일 읽기, 쓰기 가능함.
  - 버퍼를 이요
  - muti thread 에서 사용해도 안전.
  - 메서드는 `open()` 을 통해서 ..

- 파일 쓰기

  ```java
  int bytesCount = fileChannel.write(ByteBuffer src);
  ```

- 파일 읽기

  ```java
  int bytesCount = fileChannel.read(ByteBuffer dst);
  ```

- 파일 복사

  - `File.copy()`



### 파일 비동기 채널

- 왜 필요?
  - 파일 채널의 read(), write() 는 블로킹 됨
  - 즉 위 메서드 실행 중에는 UI갱신이나, 이벤트 처리를 할 수 없음.
  - 그래서 위 메서드를 처리할 때는, 별도의 스레드를 통해서 처리하는 것이 필요.
  - 그렇지만, 파일 수 증가에 따라서 스레드들도 증가하겠지. 그럼 동기 문제 생길 수 있음.
- `AsychronousFileChannel` 을 통해 문제 해결



#### TCP 블로킹 채널

- 블로킹, 넌블로킹, 비동기

  - 블로킹 : 연결요청, 연결 수락, 입출력 작업시 블로킹
  - 넌 블로킹 : 연결요청, 연결 수락, 입출력 작업시 넌블로킹

  - 비동기 : 연결요청, 연결 수락, 입출력 작업시 넌 블로킹, 스레드 풀에서 처리 한 후 콜백 메서드를 호출.

- 병렬 처리의 핵심은 스레드 풀을 사용하는 것.



#### TCP 넌블로킹 채널

- connet(), read(), accept(), read(), write() 메서드는 블로킹 없이 즉시 **리턴**
  - 그렇지만 클라이언트 요청이 없는 상태에서 accept()를 실행시키면 바로 null return

- Selector
  - 채널을 키로 등록, 작업스레드는 해당 키셋에서 하나씩 가져와서 작업을 실행.
  - 넌 블로킹은 셀렉터를 통해서 만들 수 있군.



#### TCP 비동기 채널

- connet(), read(), accept(), read(), write() 메서드는 블로킹 없이 즉시 **리턴**
- 실질적인 입출력 처리는 스레드 풀에서.
- 작업처리를 완료하면, 콜백 메서드 호출
- 콜백? completed() 
  - 어디서 호출함? 
  - 스레드풀의 작업 스레드 풀에서

- 비동기 채널 그룹을 생성할 수 있음.
  - shutdown() 은 종료하겠다는 의사만 전달.
  - 바로 종료되진 않음.
  - 비동기 채널 그룹에, 있던 채널들이 모두 닫히면, 그제서야 해당 그룹이 닫힘
  - 다만 shutdownNow() 강제종료
    - 다만 콜백 메서드를 실행하고 있는 채널은 그대로 실행됨.



#### UDP 채널

- DatagramChannel

- 블로킹, 넌 블로킹 방식 모두 사용가능

  ```java
  DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocoolFamily.INET);
  ```

  - 매개인자는 Iv4(INET) or Iv6
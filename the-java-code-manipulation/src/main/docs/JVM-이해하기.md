# 1. JVM, JDK, JRE
> JVM, JDK, JRD는 서로 어떻게 다를까?

![image](https://user-images.githubusercontent.com/22140570/94157610-6630c380-febc-11ea-8174-09f6d0cbe962.png)
- `Hello.java` -> javac(Compile) -> `Hello.class` 
- 클래스 파일 내부에 있는 것이 `ByteCode`
  ![image](https://user-images.githubusercontent.com/22140570/94157844-a3955100-febc-11ea-964f-5fc3f594c60f.png)
  - 이러한 바이트 코드를 실행하는 것이,  인터프리터 혹은 JIT Compiler 
  - 인터프리터 혹은 JIT Compiler가 기계어(OS에 특화된 코드)로 바꾼 다음에 실행시키는 것!
  - 기계어는 OS에 의존적, 특정 플랫폼에 의존적이다.
- 바이트 코드를 실행하는 JVM이 벤더에 따라 다르고, 스펙(기준)은 오라클에서 정하고 있다.

## JVM
- Java Virtual Machine
- JVM은? 바이트 코드를 실행할 수 있는 가상 머신.
  - JVM 구현체는 다양하다(오라클... openjdk, 아마존..)
  - 그리고 플랫폼에 종속적이다.
    - 왜냐면 바이트 코드를 native code로 바꿔서 실행해야 하는데, 이러한 native code는 OS에 종속적이기 때문에
- JVM은 이 홀로 제공되지 않고, JRE내부에 들어서 배포된다.

## JRE
- Java Runtime Environment
- JRE는 Java Application을 실행할 수 있는 최소한의 패키지라 보면된다.
  - JVM + Library
- 자바를 개발하는 데, 필요한 툴은 제공되지 않는다!
  - 즉 `javac`는 포함되어 있지 않다.
  
## JDK
- Java Development Kit
- JRE와 더불어서, 개발하는 tool까지 같이 제공하는
  - `javac`가 포함되어 있다.
- 오라클에서 자바 11부터는 JRE를 따로 제공하지 않는다.
  - java9부터 module 시스템이 들어와서, 나만의 JRE를 구성할 수 있음.
  
## Java
- 프로그래밍 언어
- 오라클 JDK가 11버전 부터 상용으로 사용 할 때 유료이다...
- 읽으면 좋은 글 : https://medium.com/@javachampions/java-is-still-free-c02aef8c9e04
- javap - c : class 파일 열어서, 바이트 코드 보기

## JVM 언어
- 어떠한 언어라도, .class파일 혹은 .java 로만 만들어주기만 하면 JVM을 사용할 수 있는 것이다.
- 즉 JVM에세 제공하는 안정성, 속도등을 보장받을 수 있게 된다.
- ex) Kotlin, Scala
- jar : java archive file
  - java -jar 로 실행할 수 있다.



# 2. JVM 구조

![image](https://user-images.githubusercontent.com/22140570/94505288-b3f35600-0245-11eb-84a1-bcfd25a16611.png)

## 클래스 로더 시스템

- .class 에서 byte 코드를 읽고 메모리에 저장
- 로딩 : 클래스를 읽어오고
- 링크 : 레퍼런스를 연결하고,
- 초기화 : static 값을 초기화 및 변수를 할당한다.

## 메모리

- 크게 5가지 영역
  - 중요한 것은, 메소드 영역
- **메소드** 영역 : 클래스 수준의 정보를 저장(클래스 이름, 부모 클래스 이름, 메소드, 변수, 스태틱 변수들도)
  
  - 기본적으로 Object클래스를 상속받았으니까... 부모클래스 이름에 Object가 들어가지 않을까?
  - 메소드 영역에 저장된 것은 공유할 수 있음.
- **힙** 영역 : 실제 인스턴스들이 저장되는 공간
  
  - 이 외 나머지 영역(스택, PC, 네이티브 메소드 스택)들은, thread에 국한된다.
- **스택** 영역 : thread 마다, 런타임 스택이라는 것을 만들고, 메서드 호출 스택을 쌓는다.
- **PC 레지스터** : 스택 영역에서 어떤 영역이 실행 중인지를 가르키고 있는 영역
- **네이티브 메소드 스택** : 네이티브 메소드를 실행하기 위한 별도의 스택 영역
  
  - 이 내부에 네이티브 메소드 인터페이스를 실행, 호출하고 있을 것
- 위 5가지 영역은 주로 프로파일링 할 때, 사용된다
- 네이티브 메서드?
- `Thread.currentThread()` : 이 메서드는 `java`로 구현된 것이 아님. `C`로 구현된것
  - 코어쪽으로 들어가면 네이티브가 많다..
- JNI (Java Native Interface) : 네이티브 메서드를 실행 시킬 수 있도록 도와주는 인터페이스



> 참고 

  - https://medium.com/@bschlining/a-simple-java-native-interface-jni-example-in-java-and-scala-68fdafe76f5f
  - https://javapapers.com/core-java/java-jvm-run-time-data-areas/#Program_Counter_PC_%20Register

## 실행 엔진

- 인터프리터

  ![image](https://user-images.githubusercontent.com/22140570/94506308-0c2b5780-0248-11eb-904f-356542134ced.png)

  - 위 바이트 코드를 이해해서, 한줄씩 실행하면서 네이티브 코드로 바꿔서 (기계가 이해할 수 있게) 실행하는 것.

  - 한 줄마다 컴파일 하는 것 (바이트 코드 -> 네이티브 코드)

    - 그러면 똑같은 코드가 여러번 나와도, 매번 같은 네이티브 코드로 바꾸는 것이 비효율적
      - 이럴 경우 JIT 컴파일러에게 보

- JIT 컴파일러 : 인터프리터 효율을 높이기 위해, 인터프리터가 반복적인 코드를 발견하면 이 컴파일러를 통해 미리 네이티브 코드로 바꿔둠

    - 그러면 인터프리터는 반복되는 코드를 컴파일 하지 않고, 미리 컴파일 해놓은 코드를 바로 사용할 수 있게 바뀐다.

    - 컴파일 속도를 향상

- GC

  - 옵션 조정, 커스텀해야할 경우도 있음.
  - 크게 두가지 
    1. stop-the-world를 줄이는 GC
    2. throw open GC
  - 더 이상 참조하지 않는 객체를 정리한다.



# 3. 클래스 로더

![image-20200929114623376](/Users/han/Library/Application Support/typora-user-images/image-20200929114623376.png)

- 순서 : 로딩 -> 링크 -> 초기화



## 로딩

- .class파일을 읽어서, 바이너리 파일을 만들고 **메소드 영역**에 저장함
- 메소드 영역
  - FQCN :Fully Qualify Class Name, 풀패키지 경로까지 포함한 클래스 이름
  - 클래스, 인터페이스
  - 메소드, 변수
- 로딩이 끝나면, 해당 클래스 타입의 클래스 객체를 생성하여 힙 영역에 저장
  - `Class<App> app ....` 이런 클래스가 힙 영역에 저장된다.
  - 힙, 메서드 영역은 모든 스레드에 공유된다.
- 로딩에 사용되는 로더는 3가지가 있음.
  - 클래스 로더는 *계층형 구조*
  - 부트 스트랩 클래스 로더 : JAVA_HOME\lib에 있는 코어 자바 API를 제공함. 최상위 우선 순위를 가진 클래스 로더임
    - 플랫폼 클래스 로더 : JAVA_HOME\lib/ext 폴더 또는 java.ext.dirs 시스템 변수에 해당하는 위치에 있는 클래스를 읽는다.
      - 애플리케이션 클래스 로더 : 애플리케이션 클래스 패스에서 클래스를 읽는다.
        - 애플리케이션 클래스 패스 ?
        - 애플리케이션 실행할 떄 주는 -classpath 옵션 또는 java.class.path 환경 변수의 값에 해당하는 위치
- Man-quickstart로 만들어보자
- 부트 스트랩 클래스로더는 native code로 구현되어 있음.
- ClassNotFoundException : runtimeException, POM 파일에 적절한 의존성을 추가하지 않았을 때
  - 부트에서 읽고, 없으면 플랫폼에서 읽어보고 없으면, 애플리케이션에서 읽어보는 데 
  - 이 세가지 과정을 거쳤는 데도 클래스가 없다면 위 에러가 발생한다.

## 링크

- Verify, Prepare, Resolve(optional) 단계로 나뉘어져 있음.
- Verify : .class파일 형식 자체가 유효한지 체크하는 것, 유효하지 않으면 실행 안됨(JVM 에러!)
- Prepare : 메모리를 준비하는 과정
  - 클래스 변수(static 변수), 기본값에 필요한 메모리를 준비하는 과정
- Resovle : 심볼릭 메모리 레퍼런스를, 메소드 영역에 있는 실제 레퍼런스로 교체하는 과정. 해당 과정은 선택과정임
  - 이 때 해당 과정이 실행 될수도 있고 또는, 해당 메서드가 호출 될 때 과정이 실행될 수도 있음.
  - 심볼릭 메모리 레퍼런스 : 실제 레퍼런스를 가르키고 있는 것은 아님. 논리적인 과정



## 초기화

- 링크과정에서 준비해놓은 메모리 영역에다가, static 한 변수들을 할당하는 과정(static 블럭도 이때 실행됨.)



# 정리

- 가장 중요한 부분은 바이트 코드
- 바이트 코드를 실행 전에 조작할 수도 있음.
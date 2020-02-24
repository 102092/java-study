## 참고

- https://www.inflearn.com/course/Design-pattern-java/lecture/22024



## 목차





## 1. what is the Design Pattern

- 남들이 만들어 놓은 효율적인 프로그래밍의 기준.
- 즉 다양한 요구사항에 대해 좀 더 쉽게 대응할 수 있도록 만들어 놓은 길
- 무조건 만능은 아니다.

- 배우는 것은 오리지널 파운데이션 패턴 GoF



### 클래스 다형성

- 클래스 사이 형변환, 
  - 하위 클래스 객체를 상위 클래스에 대입할 수 있음.
  - 그 반대는 안된다.
  - 왜? 하위클래스의 추가적인 변수가 있을 것을 예상할 수 없기 때문에



### 약한 결합, 강한 결합

- 강한 결합? 
  - 개발자가 생성 부터, 메모리에서 삭제까지 개발자가 관리해야함.
  - 강한 결합의 경우, 접근지정자를 `prvate` 으로 바꾸면 오류가 나옴.
  - 그렇지만 약한 결합은 오류나오지 않음.
    - <u>*즉 상황 변화에 따라 유연하게 대처할 수 있음!!!*</u>
- 약한 결합은
  - 이미 생성된 객체를 사용하는 것. 좀 더 편함. 왜? 관리해야할 것들이 줄어드니까.



```java
package di;

import java.util.Date;

public class UnderStandDI {

    public static void main(String[] args) {
        //강한 결합
        Date date = new Date();
        System.out.println(date);

    }

    public static void getDate(Date d){
        //약한 결합
        Date date = d;
        System.out.println(date);
    }

    public static void memberUse1(){
        //강한 결합, 직접생성
        Member m1 = new Member();
    }

    public static void memberUse2(Member m){
        //약한 결합, 생성된 것을 주입받는 것.
        Member m2 = m;
    }

}

class Member {
    String name;
    String nickname;

    public Member() {
    }
}
```



## 2. Singleton-Pattern

- 하나의 객체로 데이터를 일관적으로 유지하고 싶을 때 사용

- singleton
  - 아마도 객체를 하나만 생성하는 것을 유도하는 방식이 아닐까.
- 생성자를 `private` 으로 만들어놓고 하는 예가 많음.
- 여러개의 쓰레드를 만들 때는, 동기화 처리를 해놓지 않으면, 반복횟수만큼 쓰레드가 만들어진다.
  - `synchronized`  비싼 비용을 소비한다.
- 프레임워크에서 자체적으로 singleton pattern을 적용시켜놓은 경우가 많다.



## 3. Flyweight-Pattern

- 싱글턴 클래스의 역할과 비슷
- 객체의 생성을 제한
- 어떨 경우?
  1. 중복 생성될 가능성이 높을 경우(공통 자원 형태로 생성하면 좋음)
  2. 자원 생성 비용은 큰 데 사용 빈도가 낮으면.(요청이 있을 때만 사용)

- 예시

  ![](https://mblogthumb-phinf.pstatic.net/20160329_279/2feelus_14592612255343mv2h_PNG/2016-03-29_at_11.28.36_PM.png?type=w2)

  - 공통된 것을 하나를 미리 만들어 놓고, 
  - 공통되지 않은 위치 정보를 가진 객체가 생성될 때, 이미 생성한 Model 객체를 가져다가 쓰는 방식

- 장점
  - 많은 객체 만들 때, 성능 향상
  - 많은 객체 만들 때, 메모리 줄일 수 있음.
- 단점
  
- 개별 설정이 필요할 때는 수정하기 힘듬.
  
- 예시
  - java.lang.String
  - java.Integer#valueOf(int)

- Factory
  
  - 자원의 생성을 관리할 클래스



## 4. Builder-Pattern

- 객체를 생성할 때 사용하는 패턴
- 이펙티브 자바 공부허자
- 언제 적용?

  - <u>규칙, 생성자에 인자가 많을 때</u>
  - 만약 객체의 멤버 변수가 10개가 넘어가면, 생성하기가 쉽지 않으니까.
- 왜 사용?
  - 객체 생성을 조금 더 **가독성** 있고 깔끔하면서 **유연하게** 하기 위해서

- *intellij*에서 setter부분에서 Builder 형식으로 setter를 만드는 것을 지원한다.



## 5. Observer-Pattern

- **1: 다 의존성**을 가짐
- 한 객체의 상태가 바뀌면, 그 객체에 의존한 다른 객체들 한테도, 자동으로 연락이 감. 
  - 즉 자동으로 내용이 갱신되는 느낌.
- 데이터가 콘트롤러 클래스에 들어오면, 해당 클래스는 그것을 기억하고 다른 객체에게 알려주는 형식으로 진행되어야함.

- 이걸 어디에 사용할까?
  - Android view , Button등 이벤트를 받을 때
  - 버튼 상태를 누르면, OnClickListener가 그 신호를 받아서 알려주는 형식
- 한계점은 뭐가 있을까?
  - observer들은 클래스, 즉 하나만 상속받을 수 있는 점이 단점. 
  - 다른 클래스를 상속받고 있는 클래스는, observer를 클래스를 상속받을 수 없어.
  - 그래서 이부분은 인터페이스를 통해서 해결할 수 있음.



## 6. Adapter-Pattern

- Wrapper 패턴
- 어떤 것을 포장해서 제공해주는 형식
- 클래스로도, 인스턴스로도 할 수 있음.
- 왜 사용?
  - 기존의 클래스를 재사용하여 필요한 클래스를 만들기 위해서.

- 중요점
  - 이미 만들어진 클래스를 재사용했기에, 별 문제 없겠지 라고 생각할 경우가 많음.
  - 그렇지만 항상 예상치 못한 문제가 발생할 가능성이 높음.
  - 그래서 반드시 테스트를 해봐야함.
- 예시
  1. Bridge 패턴
  2. Decorator 패턴

- 기존이 존재하던 코드를 변경없이 사용하고 싶을 때 사용하는 패턴



## 7. Facade-Pattern

- adapter-pattern과 거의 같은 방식, 그렇지만 **다른 목적**
- 어댑터 패턴은 , 원래 코드를 다른 코드와 작동할 수 있도록 만들어주는 래퍼를 제공하지만,
- 파사드 패턴은 원래 코드를 더 쉽게 처리할 수 있도록 하는 래퍼를 제공해줌.

- 왜 사용?

  - 최소 단위로 클래스를 설계할 수 있도록 해줌. == OOP

- 예시

  ```java
  Computer computer = new Computer();
  Light light = new Light();
  Radio radio = new Radio();
  
  //이전에는 각각 객체에 모두 접근하여 off메서드를 실행시켜줘야했다면
  computer.turnOff();
  light.turnOff();
  radio.turnOff();
  
  //파사드 패턴을 적용하면, 좀 더 쉽게 적용시켜준다.
  HomeFacade home = new HomeFacade(Computer, light, radio);
  home.homeIn();
  ```

  



## 8. Decorator-Pattern

- 객체의 결합을 통해 기능을 동적으로 유연하게 확장해주도록 도와주는 패턴

- 예시 : 자바 입출력 필터 스트림

  ```java
  BufferedReader br = null;
  try {
    br = new BufferedReader(new FileReader(new File("test.txt"))); //이부분
  } catch (Exception e) {}
  ```

- 단점은?

  - *자잘한 객체들이 너무 많이 추가*될 수도 있고,
  - 코드들이 *필요 이상으로 복잡*해줄 수 있음.

- 추상클래스를 이용

- 약간 Spring DI느낌?

- 예시

  ```java
  Student g1 = new AmericanStudent();
  System.out.println(g1.getDescription); // American Student
  
  Science g2 = new Science(g1);
  System.out.println(g2.getDescription);// American Student + Like Science
  
  Art g3 = new Art(g2);
  System.out.prinln(g3.getDescription); // American Student + Like Science + Like Art
  ```

  

## 9. Bridge-Pattern

- 이해가 필요
  1. 기능 클래스 계층 : 새로운 기능을 추가하고 싶은 경우
  2. 구현 클래스 계층 : 새로운 구현을 추가하고 싶은 경우
- 아래 코드를 보면 이해가 빠를 듯.

- 인터페이스에 추가된 추상메서드는 반드시 구현 클래스에서 재정의 되어야 함.
- 기능을 추가하기 위해서는 인터페이스에서 추가해야함.

- 브릿지, 다리 역할 누구의?
  - 기능 계층과 구현의 계층을 연결
- 단점은 디자인이 복잡. 객체간 연결과정을 파악하기가 힘들 수도 있음.
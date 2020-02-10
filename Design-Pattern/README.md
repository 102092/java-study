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


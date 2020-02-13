package di;

import java.util.Date;

public class UnderStandDI {

  public static void main(String[] args) {
    //강한 결합
    Date date = new Date();
    System.out.println(date);

  }

  public static void getDate(Date d) {
    //약한 결합
    Date date = d;
    System.out.println(date);
  }

  public static void memberUse1() {
    //강한 결합, 직접생성
    Member m1 = new Member();
  }

  public static void memberUse2(Member m) {
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


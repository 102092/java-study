package com.spring.hello.discount;

import com.spring.hello.member.Member;

public interface DiscountPolicy {

  /**
   * @return 할인 대상 금액
   */
  int discount(Member member, int price);

}

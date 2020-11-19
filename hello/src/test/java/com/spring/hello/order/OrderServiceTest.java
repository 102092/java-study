package com.spring.hello.order;

import static org.junit.jupiter.api.Assertions.*;

import com.spring.hello.member.Grade;
import com.spring.hello.member.Member;
import com.spring.hello.member.MemberService;
import com.spring.hello.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  void create_order() {
    Long memberId = 1L;
    Member member = new Member(memberId, "hello", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

}

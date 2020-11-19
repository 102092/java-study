package com.spring.hello;

import com.spring.hello.member.Grade;
import com.spring.hello.member.Member;
import com.spring.hello.member.MemberService;
import com.spring.hello.member.MemberServiceImpl;
import com.spring.hello.order.Order;
import com.spring.hello.order.OrderService;
import com.spring.hello.order.OrderServiceImpl;

public class OrderApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    Long memberId = 1L;
    Member member = new Member(memberId, "A", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    System.out.println(order);
  }

}

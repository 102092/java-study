package com.spring.hello.order;

import com.spring.hello.discount.DiscountPolicy;
import com.spring.hello.discount.FixDiscountPolicy;
import com.spring.hello.member.Member;
import com.spring.hello.member.MemberRepository;
import com.spring.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}

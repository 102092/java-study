package com.spring.hello;

import com.spring.hello.member.Grade;
import com.spring.hello.member.Member;
import com.spring.hello.member.MemberService;
import com.spring.hello.member.MemberServiceImpl;

public class MemberApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    Member member = new Member(1L, "A", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new : " + member.getName());
    System.out.println("find : " + findMember.getName());
  }
}

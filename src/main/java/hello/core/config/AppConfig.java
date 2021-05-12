package hello.core.config;

import hello.core.repository.member.MemberRepository;
import hello.core.repository.member.MemoryMemberRepository;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.discount.DiscountPolicy;
import hello.core.service.discount.FixDiscountPolicy;
import hello.core.service.discount.RateDiscountPolicy;
import hello.core.service.order.OrderService;
import hello.core.service.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

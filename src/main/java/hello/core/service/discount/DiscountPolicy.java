package hello.core.service.discount;

import hello.core.domain.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}

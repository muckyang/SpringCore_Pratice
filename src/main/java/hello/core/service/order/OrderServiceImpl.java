package hello.core.service.order;

import hello.core.domain.member.Member;
import hello.core.domain.order.Order;
import hello.core.repository.member.MemberRepository;
import hello.core.repository.member.MemoryMemberRepository;
import hello.core.service.discount.DiscountPolicy;
import hello.core.service.discount.FixDiscountPolicy;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}

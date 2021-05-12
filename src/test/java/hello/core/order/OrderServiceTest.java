package hello.core.order;

import hello.core.config.AppConfig;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import hello.core.domain.order.Order;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.order.OrderService;
import hello.core.service.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "item1", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}

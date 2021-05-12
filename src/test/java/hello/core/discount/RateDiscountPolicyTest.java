package hello.core.discount;

import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import hello.core.service.discount.DiscountPolicy;
import hello.core.service.discount.RateDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {


    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인")
    void vip_o(){
        Member member = new Member(1L,"memberA", Grade.VIP);

        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }



    @Test
    @DisplayName("VIP 아니면 할인 없음")
    void vip_x(){
        Member member = new Member(1L,"memberA", Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }


}

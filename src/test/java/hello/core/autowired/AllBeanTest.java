package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import hello.core.service.discount.DiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

//동적 Bean 선택 
public class AllBeanTest {

    @Test
    void findAllBeanTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L,"memberA", Grade.VIP);
        int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member,20000,"rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);
    }


    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap : " + policyMap);
            System.out.println("policies : " + policies);
        }

        public int discount(Member member, int price, String fixDiscountPolicy) {
            DiscountPolicy discountPolicy = policyMap.get(fixDiscountPolicy);
            return discountPolicy.discount(member,price);
        }
    }
}
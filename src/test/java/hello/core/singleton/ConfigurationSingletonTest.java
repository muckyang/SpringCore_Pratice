package hello.core.singleton;

import hello.core.config.AppConfig;
import hello.core.repository.member.MemberRepository;
import hello.core.service.member.MemberServiceImpl;
import hello.core.service.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 싱글턴 컨테이너 ")
    void containerTest(){
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberServiceImpl memberService =ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService =ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository =" + memberRepository);
        System.out.println("memberService -> memberRepository =" + memberRepository1);
        System.out.println("orderService -> memberRepository =" + memberRepository2);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}

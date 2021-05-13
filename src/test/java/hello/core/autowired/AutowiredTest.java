package hello.core.autowired;

import hello.core.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {//Member는 spring에서 관리되지 않음
            System.out.println("noBean1 : " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {//생성자 주입시 특정필드에 넣어주기도 가능함!
            System.out.println("noBean2 : " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 : " + noBean3);
        }


    }
}

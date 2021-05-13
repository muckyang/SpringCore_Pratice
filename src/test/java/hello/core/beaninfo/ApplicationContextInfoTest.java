package hello.core.beaninfo;

import hello.core.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println("================== 전체 빈 ==================");
        for (String name : beanDefinitionNames) {
            Object bean = ac.getBean(name);
            System.out.println(bean + " , " + name);
        }
        System.out.println();
        System.out.println("================== 직접등록한 빈 ==================");
        for (String name : beanDefinitionNames) {
            Object bean = ac.getBean(name);
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println(bean + " , " + name);
            }
        }
    }
}

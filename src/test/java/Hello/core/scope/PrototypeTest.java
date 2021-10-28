package Hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    @DisplayName("프로토타입 빈 찾기")
    void prototypeBeanFind() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
        // when
        System.out.println("find prototypeBean1");
        prototypeBean bean = ac.getBean(prototypeBean.class); //이 때 새로운 빈 생성
        System.out.println("find prototypeBean2");
        prototypeBean bean2 = ac.getBean(prototypeBean.class);//이 때 새로운 빈 생성

        // then
        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean).isNotEqualTo(bean2); // bean 1과 bean2 는 서로 다르다.

        ac.close(); //destroy 가 호출되지 않음!!!
    }

    @Test
    @DisplayName("프로토타입 빈 삭제")
    void prototypeBeanDestroy() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
        prototypeBean bean = ac.getBean(prototypeBean.class);
        prototypeBean bean2 = ac.getBean(prototypeBean.class);

        // when
        //NOTE: 프로토타입 빈 종료하고 싶으면 클라이언트가 직접 수동으로 종료해줘야함
        System.out.println("distroy prototypeBean1");
        bean.destroy();
        System.out.println("distroy prototypeBean1");
        bean2.destroy();

        // then
        ac.close(); //destroy 가 호출되지 않음!!!
    }

    //  @Component 가 없는데용??
    //  ac 에 이 클래스를 등록해버리면 그냥 컴포넌트 스캔처럼 동작해서 바로 스프링 빈으로 등록함. 없어도 ㄱㅊ
    @Scope("prototype")
    static class prototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("prototypeBean.destroy");
        }

    }
}

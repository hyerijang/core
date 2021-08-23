package Hello.core;

import Hello.core.member.MemberService;
import Hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        //AppConfig.class 내 설정 정보를 사용해서 applicationContext 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//name, return type
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);//name, return type
    }
}

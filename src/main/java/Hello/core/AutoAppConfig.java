package Hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

    // ERROR : [수동 빈 자동빈 충돌]
    // - 테스트는 통과하는데, 스프링 부트 실행은 x
    //최근 스프링 부트는 자동과 수동이 충돌하면 오류 나도록 변경 됨.
    /*  The bean 'memoryMemberRepository', defined in class path resource [Hello/core/AutoAppConfig.class], could not be registered.
        A bean with that name has already been defined in file [C:\Users\Hyeri\Documents\MyProject\Spring\core\out\production\classes\Hello\core\member\MemoryMemberRepository.class]
        and overriding is disabled.
    */

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        //Overriding bean definition for bean 'memoryMemberRepository' with a different definition
//        System.out.println("같은 이름의 bean이 있으면 수동등록이 우선됩니다.");
//        return new MemoryMemberRepository();
//    }

}

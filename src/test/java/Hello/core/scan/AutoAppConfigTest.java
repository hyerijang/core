package Hello.core.scan;

import Hello.core.AutoAppConfig;
import Hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        // when
        MemberService memberService = ac.getBean(MemberService.class);
        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}

package Hello.core.web;

import Hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    // Error creating bean with name 'myLogger': Scope 'request' is not active for the current thread;
    private final MyLogger myLogger; //scope 의 범위가 "request"이므로 의존관계 주입 시 오류 발생

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass()); //이 mylogger 는 껍데기
        // Note : myLogger = class Hello.core.common.MyLogger$$EnhancerBySpringCGLIB$$72b82af4
        //  - CGLIB 라이브러리 사용,  내 클래스를 상속받은 가짜 프록시 객체 주입.

        //진짜를 동작
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }


}

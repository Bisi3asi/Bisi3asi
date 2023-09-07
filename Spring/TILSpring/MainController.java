package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Controller 애너테이션 : 스프링부트의 컨트롤러 역할
public class MainController {
    
    @GetMapping("/sbb") // GetMapping 애너테이션, 요청한 URL과의 매핑
    // 즉, /sbb url과 매핑되는 index 메서드를 MainController에서 찾아 실행.
    // 기본값 기준 localhost:8080/sbb로 접속 시 index의 문자열이 출력
    @ResponseBody
    public String index(){
        return "안녕하세요 sbb에 오신 것을 환영합니다.";
    }
}

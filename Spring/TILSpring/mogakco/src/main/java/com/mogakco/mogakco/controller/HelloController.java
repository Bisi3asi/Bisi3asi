package com.mogakco.mogakco.controller;

import java.lang.annotation.Retention;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // 일반 방식으로 타이핑을 치면 getMapping으로 연결,
    // 톰캣 서버가 HelloController에 GetMapping된 이 메소드 실행
    @GetMapping("hello")
    public String hello(Model model) {

        // model 객체의 attributeName인 data명으로 html파일에 데이터를 넘김
        // 데이터 명은 data로 매핑, 출력한 데이터 value는 mogakco
        model.addAttribute("data", "mogakco");

        // return값을 주면 viewresolver가 화면을 찾아서 처리한다.
        // 처리명 : hello -> templates 폴더에서 template.html을 렌더링 하라고 지시
        return "hello";
    }

    @GetMapping("hello-mvc")
    // hello-mvc?name="String" 으로 접속 시 해당 "String"이 표출된다.
    // 컨트롤러가 view로 값을 던질 때 사용자가 주소창에 입력한 String 값을 통해
    // model(name:"String")으로 매핑해 키값은 name, value값은 String으로 리턴해주기 때문
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
package com.mogakco.mogakco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc") //localhost:8080/hello-mvc?name="String"
    // RequestParam("name") : 사용자의 뷰로 name의 value 값을 받겠다
    // hello-mvc?name="String" 으로 접속 시 해당 "String"이 표출된다.
    // 컨트롤러가 view로 값을 던질 때 사용자가 주소창에 입력한 String 값을 통해
    // model(name:"String")으로 매핑해 키값은 name, value값은 String으로 리턴해주기 때문
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") //localhost:8080/hello-string?name="String"
    @ResponseBody // 응답 바디부에 내가 이 내용을 직접 넣겠다 라는 뜻
    // 결과를 보면 html이나 view 없고, 해당 string이 그대로 내려옴
    public String helloString(@RequestParam("name") String name) {
        return "hello! " + name;
    }

    @GetMapping("hello-api") //localhost:8080/hello-api?name="String"
    @ResponseBody // responsebody가 있으면 viewresolver 안가고 http 응답에 그대로 데이터를 넘김
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // 객체 데이터 리턴 시 JsonConverter 작동 : 스프링은 객체 → JSON 형태 반환을 기본 정책으로 채택
        // 단순 문자 리턴 시  StringConverter가 작동

    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
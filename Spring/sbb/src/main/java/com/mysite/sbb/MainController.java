package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/sbb")
    @ResponseBody // URL 요청에 대한 응답으로 리턴하라는 의미
    public String index(){
        return "this is MainController";
    }

    //redirect
    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
        // redirect : URL로 리다이렉트(새로운 URL로 요청하는 것)
        // foward : URL로 포워드(기존 값이 유지된 상태로 URL이 전환)
    }
}

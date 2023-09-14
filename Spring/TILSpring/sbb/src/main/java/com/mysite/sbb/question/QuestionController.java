package com.mysite.sbb.question;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;;

@RequiredArgsConstructor
// 스프링 DI 규칙에 의해 자동으로 Question Service 객체가 생성자 방식으로 주입\
@Controller
public class QuestionController{

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model){
        // model 객체는 따로 생성할 필요 없이 컨트롤러 메서드의
        // 매개변수로만 지정하면 스프링부트가 자동으로  model 객체 생성
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);       
        return "question_list";
        // resources > templates > question_list.html을 불러옴
    }
}
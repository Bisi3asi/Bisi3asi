package com.mysite.sbb.question;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;;

@RequestMapping("/question")
// url의 프리픽스를 고정하는 애너테이션
// url의 매핑 규칙을 정의
@RequiredArgsConstructor
// 스프링 DI 규칙에 의해 자동으로 Question Service 객체가 생성자 방식으로 주입\
@Controller
public class QuestionController{

    private final QuestionService questionService;

    // 질문 목록 매핑
    @GetMapping("/list")
    public String list(Model model){
        // model 객체는 따로 생성할 필요 없이 컨트롤러 메서드의
        // 매개변수로만 지정하면 스프링부트가 자동으로  model 객체 생성
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);       
        return "question_list";
        // resources > templates > question_list.html을 불러옴
    }
    
    // 상세 질문 매핑
    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
    // @PathVariable : 변하는 id 값을 얻기 위해 사용하는 애너테이션
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
        // resources > templates > question_detail.html로 불러옴
    }
}
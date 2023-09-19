package com.mysite.sbb.question;
import com.mysite.sbb.answer.AnswerForm;

import org.springframework.ui.Model;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

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
    public String list(Model model, @RequestParam(value="page", defaultValue ="0") int page){
        // get 방식으로 요청된 URL에서 page 값 가져오기 위해 RequestParam 추가
        // 스트링 부트의 페이징은 첫페이지 번호가 0임
        // model 객체는 따로 생성할 필요 없이 컨트롤러 메서드의
        // 매개변수로만 지정하면 스프링부트가 자동으로 model 객체 생성
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        // model을 통해 paging을 템플릿으로 전달 
        return "question_list";
        // resources > templates > question_list.html을 불러옴
    }
    
    // 상세 질문 매핑
    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
    // @PathVariable : 변하는 id 값을 얻기 위해 사용하는 애너테이션
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
        // resources > templates > question_detail.html로 불러옴
    }
    
    // 질문 등록하기 매핑(get) *참고 : question_list.html
    // question/list -> question/create :: get 방식으로 요청
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    // 질문 등록하기 매핑(post) *참고 : question_form.html
    // question/create -> question/create :: post 방식으로 리다이렉트 요청
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        // Sping 바인딩 기능 : QuestionForm에 있는 subject, content가 자동으로 매개변수 바인딩
        // @Valid 애너테이션 : QuestionForm의 설정한 검증 기능이 동작함
        // @BindingResult : Valid 애너테이션으로 인해 검증 수행 결과를 의미하는 객체
        // 따라서 @Valid 바로 뒤에는 반드시 BindingResult가 위치해야 한다.

        // 질문 저장
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/list";
        // 질문 저장 후 질문목록으로 redirect
        // resources > templates > question_form.html로 불러옴
    }
}
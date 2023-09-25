package com.mysite.sbb.question;
import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import org.springframework.ui.Model;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
// url의 프리픽스를 고정하는 애너테이션
// url의 매핑 규칙을 정의
@RequiredArgsConstructor
// 스프링 DI 규칙에 의해 자동으로 Question Service 객체가 생성자 방식으로 주입\
@Controller
public class QuestionController{

    private final QuestionService questionService;
    private final UserService userService;

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
    // PreAuthorize("isAuthenticated()") : 로그인이 필요한 메소드임을 나타냄
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    // 질문 등록하기 매핑(post) *참고 : question_form.html
    // question/create -> question/create :: post 방식으로 리다이렉트 요청
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
        // Sping 바인딩 기능 : QuestionForm에 있는 subject, content가 자동으로 매개변수 바인딩
        // @Valid 애너테이션 : QuestionForm의 설정한 검증 기능이 동작함
        // @BindingResult : Valid 애너테이션으로 인해 검증 수행 결과를 의미하는 객체
        // 따라서 @Valid 바로 뒤에는 반드시 BindingResult가 위치해야 한다.

        // 질문 저장
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(),questionForm.getContent(), siteUser);
        return "redirect:/question/list";
        // 질문 저장 후 질문목록으로 redirect
        // resources > templates > question_form.html로 불러옴
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    // 질문 수정 버튼 GET 방식의 호출
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        if(!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
        }
        questionForm.setSubject(question.getSubject());
        questionForm.setContent(question.getContent());
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    // 질문 수정 완료 후 클릭 시 POST 형식의 요청 처리
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult, 
            Principal principal, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
    // 질문 삭제
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.questionService.delete(question);
        return "redirect:/";
    }
}
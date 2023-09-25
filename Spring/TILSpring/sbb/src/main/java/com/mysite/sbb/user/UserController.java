package com.mysite.sbb.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
    public class UserController {
    
    private final UserService userService;
    @GetMapping("/signup")
    //url이 GET으로 요청되면 회원 가입 템플릿 렌더링
    public String signup(UserCreateForm userCreateForm){
        return "signup_form";
    }

    @PostMapping("/signup")
    //POST로 요청되면 회원가입 진행
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult BindingResult){
        if (BindingResult.hasErrors()){
            return "signup_form";
        }
        
        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            BindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            // 비밀번호 1과 2가 일치하지 않으면 오류 발생
            return "signup_form";
        }

        try {
            userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), 
                userCreateForm.getPassword1());      
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            BindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch(Exception e){
            e.printStackTrace();
            BindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
    
}

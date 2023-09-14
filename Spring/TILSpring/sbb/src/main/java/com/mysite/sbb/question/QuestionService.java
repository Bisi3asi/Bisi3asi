package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// 스프링 DI 규칙에 의해 자동으로 final 속성의 생성자를 생성하는 애너테이션
@Service
// 서비스를 거쳐 QuestionRepository를 불러 질문 목록 데이터 조회
// ※ 서비스 : 데이터 처리를 위해 작성하는 클래스
// ※ 서비스가 필요한 이유 1. 컨트롤러가 리포지터리에 접근하는 것보다 서비스를 통해 접근하는 것이 보안상 안전
// ※ 서비스가 필요한 이유 2. 서비스로 모듈화 실현
public class QuestionService {
    
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }
}

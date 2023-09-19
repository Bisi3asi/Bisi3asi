package com.mysite.sbb.question;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.time.LocalDateTime;
import com.mysite.sbb.DataNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }
        else {
            throw new DataNotFoundException("question not found");       }
    }

    public void create(String subject, String content){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }

    // 질문 목록 조회
    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        // 작성일시 역순으로(최신 question이 위로 오게끔) 정렬
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        // page :: 조회할 페이지 번호, pageSize : 보여줄 개시물 갯수
        // 세번재 파라미터로 Sort 객체 전달 시 해당 정렬에 맞춰 보여줌
        return this.questionRepository.findAll(pageable);
        // pageable :: 데이터 전체를 조회하지 않고 해당 페이지 데이터만 조회
        // http://localhost:8080/question/list?page="number" 로 들어가면 페이지 조회
    }

}



package com.mysite.sbb.question;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.time.LocalDateTime;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.answer.Answer;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
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

    // 질문생성
    public void create(String subject, String content, SiteUser user){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    // 질문 목록 조회, kw :: 검색어를 매개변수로 전달
    public Page<Question> getList(int page, String kw){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        // 작성일시 역순으로(최신 question이 위로 오게끔) 정렬
        
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        // page :: 조회할 페이지 번호, pageSize : 보여줄 개시물 갯수
        // 세번재 파라미터로 Sort 객체 전달 시 해당 정렬에 맞춰 보여줌
        
        Specification<Question> spec = search(kw);
        // Specification 객체 호출하여 findAll 메소드 호출시 검색어 전달
        
        return this.questionRepository.findAll(spec, pageable);
        // pageable :: 데이터 전체를 조회하지 않고 해당 페이지 데이터만 조회
        // http://localhost:8080/question/list?page="number" 로 들어가면 페이지 조회
    }

    // 질문 수정
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    // 질문 삭제
    public void delete(Question question){
        this.questionRepository.delete(question);
    }

    // 질문 추천
    public void vote(Question question, SiteUser siteUser) {
        question.getVoter().add(siteUser);
        this.questionRepository.save(question);
    }

    // 질문 비추천
    public void unvote(Question question, SiteUser siteUser) {
        question.getUnvoter().add(siteUser);
        this.questionRepository.save(question);
    }
    // cb.like :: like 검색
    
    // 검색
    // specification 활용 데이터 쿼리 jpa 활용 검색
    private Specification<Question> search(String kw) {
        // String kw 기준으로 (질문, 답변) 작성자, 답변 내용, 질문 제목, 질문 내용 검색
        return new Specification<>() {
            private static final long serialVersionUID = 1L;
            @Override
            // 문자열이 포함된 데이터를 question, answer, site_user(q.author, a.author) 테이블 대상 검색
            public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);  // 중복을 제거 
                Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT);
                // Question SiteUser 아우터 조인(author 속성으로 연결되어 있음) : 질문자 검색
                Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
                // Question Answer 아우터 조인(answerList 속성으로 연결되어 있음) : 답변 내용 검색
                Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT);
                // Answer SiteUser 아우터 조인(author 속성으로 연결되어 있음) : 답변 작성자 검색
                return cb.or(cb.like(q.get("subject"), "%" + kw + "%"), // 제목 
                // cb.or :: or 검색, cb,like :: like 검색
                        cb.like(q.get("content"), "%" + kw + "%"),      // 내용 
                        cb.like(u1.get("username"), "%" + kw + "%"),    // 질문 작성자 
                        cb.like(a.get("content"), "%" + kw + "%"),      // 답변 내용 
                        cb.like(u2.get("username"), "%" + kw + "%"));   // 답변 작성자 
            }
        };
    }
}



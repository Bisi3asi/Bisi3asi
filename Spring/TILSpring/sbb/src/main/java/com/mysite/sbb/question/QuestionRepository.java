package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface QuestionRepository extends JpaRepository<Question, Integer>{
    // ★ 메소드 내용을 구현하지 않아도 실행이 된다?!
        // JpaRepository를 상속한 QuestionRepository가 생성될 때
        // * 심지어 DI에 의해 스프링이 자동으로 QuestionRepository 생성한다
        // JPA가 해당 메서드명을 분석해 쿼리를 만들고 실행한다
    
    Question findBySubject(String subject);
    // subject로 ID를 찾는 메소드
        
    Question findBySubjectAndContent(String subject, String content);
    // subject와 content로 ID를 찾는 메소드

    List<Question> findBySubjectLike(String subject);
    
    Page<Question> findAll(Pageable pageable);
    // 페이징 구현
}
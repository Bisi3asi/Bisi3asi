package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
// 데이터를 자유롭게 변경 가능한 Setter 메소드는 허용하지 않는 것이 
// 일반적인 개발에서 안정적임

@Getter
@Setter
@Entity
public class Question {
    @Id // id 속성을 기본 키로 저장해 데이터베이스에 동일 값으로 저장 가능
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // GeneratedValue 애너테이션 : 데이터 저장 속성 값이 1씩 자동 증가해 저장
    // strategy : 고유번호 생성하는 옵션, 생략 시 모두 동일한 시퀸스로 번호 생성
    // GenerationTupe.IDENTITY : 해당 컬럼만의 독립적인 시퀸스 생성

    private Integer id;
    

    @Column(length = 200)
    // length : column 길이 정의 시 사용
    private String subject;

    @Column(columnDefinition = "TEXT")
    // columnDefinition : column 속성 정의 시 사용
    // columnDefinition = "TEXT"는 내용처럼 글자 수 제한할 수 없는 경우
    private String content;

    private LocalDateTime modifyDate;
    private LocalDateTime createDate;
    // 실제 테이블 컬럼명 : create_date
    // 대소문자 형태의 카멜 케이스 이름은 소문자로 변경되고 언더바로 구분

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // One to Many : 한개의 질문에 여러개의 답변이 달림, 1:N 관계
    // mappedBy : 참조 엔티티의 속성명
    // CascadeType.REMOVE : 질문 삭제 시 그에 달린 답변도 모두 삭제
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
    // 글 작성자 :: 작성자는 여러개의 질문을 작성할 수 있음(ManyToOne)

    @ManyToMany
    Set<SiteUser> voter;

    @ManyToMany
    Set<SiteUser> unvoter;
}

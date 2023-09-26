package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import com.mysite.sbb.question.*;
import com.mysite.sbb.user.SiteUser;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @ManyToOne // N:1 관계, Answer에서 Many를 참조할 수 있다.
    private Question question;
    // 질문 엔티티와 연결된 속성임을 명시적으로 표시

    @ManyToOne
    private SiteUser author;
    // 답변 작성자 :: 작성자는 여러개의 답변을 작성할 수 있음(ManyToOne)

    @ManyToMany
    Set<SiteUser> voter;
}

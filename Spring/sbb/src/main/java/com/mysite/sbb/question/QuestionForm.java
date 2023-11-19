package com.mysite.sbb.question;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="제목은 필수 입력항목입니다.")
    // @NotEmpty : Null 혹은 빈 문자열을 허용하지 않음
    @Size(max=100, message="제목은 100자 이하로 작성해주세요.")
    // @Size : 문자 길이 제한
    private String subject;

    @NotEmpty(message="내용은 필수 입력항목입니다.")
    private String content;
}

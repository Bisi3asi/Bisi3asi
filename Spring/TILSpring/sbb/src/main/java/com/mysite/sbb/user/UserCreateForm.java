package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 25) 
    // 폼 사이즈 유효성 검증
    @NotEmpty(message = "사용자 ID는 필수 항목입니다.")
    private String username;

    @NotEmpty(message = "사용자 비밀번호는 필수 항목입니다.")
    private String password1;

    @NotEmpty(message = "사용자 비밀번호는 필수 항목입니다.")
    private String password2;

    @NotEmpty(message = "사용자 이메일은 필수 항목입니다.")
    @Email
    // 해당 속성의 값이 이메일 형식과 일치하는지 검증
    private String email;
}

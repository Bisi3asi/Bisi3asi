package com.mysite.sbb.user;
import lombok.Getter;

@Getter
public enum UserRole {
    // 사용자에게 ADMIN과 USER 2개의 권한을 부여
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value){
        this.value = value;
    }

    private String value;
}

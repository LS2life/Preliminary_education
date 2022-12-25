package com.ex.ssg.user;

import lombok.Getter;

// 상수 자료형이므로 Setter없이 Getter만 사용.
@Getter
// enum 은 열거 자료형
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}


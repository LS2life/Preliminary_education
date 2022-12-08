package com.wiki.jumpspring.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

    @Size(min = 3,max = 25)
    @NotEmpty(message = "사용자 ID는 필수항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호 입력해주세요")
    private String password1;


    @NotEmpty(message = "비밀번호 확인을 입력해주세요")
    private String password2;
    

    @NotEmpty(message = "이메일도 주세요")
    @Email
    private String email;
}

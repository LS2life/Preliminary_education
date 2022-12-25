package com.ex.ssg.answer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;
    
}

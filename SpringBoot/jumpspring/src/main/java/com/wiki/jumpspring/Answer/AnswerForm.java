package com.wiki.jumpspring.Answer;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

    @NotEmpty(message = "내용은 필수 항목 입니다.")
    private String content;
    
}

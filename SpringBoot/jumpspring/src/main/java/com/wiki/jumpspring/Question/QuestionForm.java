package com.wiki.jumpspring.Question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

    // 빈 문자열을 허용하지 않음
    @NotEmpty(message="제목은 필수 항목입니다.")
    // 입력 최대 길이. 200바이트를 넘을 수 없다.
    @Size(max=200)
    private String subject;

    @NotEmpty(message="내용은 필수 항목입니다.")
    private String content;
    
}

package com.ex.ssg;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// DataNotFoundException이 발생하면 @ResponseStatus 애너테이션에 의해 404 오류(HttpStatus.NOT_FOUND)가 발생한다.
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="entity not found")
public class DataNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message) {
        super(message);
    }

    
}

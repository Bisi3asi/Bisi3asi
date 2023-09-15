package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entitiy not found")
// ResponseStatus 애너테이션에 의해 DanaNotFoundException 발생 시
// HttpStatus.NOT_FOUND value에 의해 404가 나타날 것이다.
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message){
        super(message);
    }
}

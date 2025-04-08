package com.bootcamp.avanade.api_rede.controller.advices;

import com.bootcamp.avanade.api_rede.exceptions.post.PostNotFoundException;
import com.bootcamp.avanade.api_rede.exceptions.post.PostNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PostControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Object> handlePostNotFound(PostNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PostNullException.class)
    public ResponseEntity<Object> handlePostNull() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verifique os campos e tente novamente");
    }
}

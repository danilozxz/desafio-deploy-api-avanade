package com.bootcamp.avanade.api_rede.controller.advices;

import com.bootcamp.avanade.api_rede.exceptions.comment.CommentNotFoundException;
import com.bootcamp.avanade.api_rede.exceptions.comment.ContentNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentControllerAdvice {

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<Object> handleCommentNotFound(CommentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ContentNullException.class)
    public ResponseEntity<Object> handleContentNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo content não pode ser vazio ou nulo");
    }
}

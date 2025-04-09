package com.bootcamp.avanade.api_rede.controller.advices;

import com.bootcamp.avanade.api_rede.dto.user.UserUpdateDTO;
import com.bootcamp.avanade.api_rede.exceptions.user.EmailExistsException;
import com.bootcamp.avanade.api_rede.exceptions.user.UserNotFoundException;
import com.bootcamp.avanade.api_rede.exceptions.user.UsernameExistsException;
import com.bootcamp.avanade.api_rede.exceptions.user.UsernameNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameNullException.class)
    public ResponseEntity<Object> handleInvalidUsername () {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo username não pode ser vazio ou nulo");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound (UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<Object> handleUsernameExists (UsernameExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<Object> handleEmailExists (EmailExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}

package com.application.todo.todos.utils;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<?> handleCustomException(CustomException e){
        return ErrorResponseEntity.toResponse(e.getErrorCode());
    }
}

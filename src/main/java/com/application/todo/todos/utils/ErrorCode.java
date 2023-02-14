package com.application.todo.todos.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    TODOS_NOT_FOUND (HttpStatus.NOT_FOUND,"존재하지 않는 TODO 입니다.");
    private final HttpStatus httpStatus;
    private final String message;
}

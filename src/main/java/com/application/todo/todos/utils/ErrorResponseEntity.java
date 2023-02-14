package com.application.todo.todos.utils;

import lombok.Builder;
import org.springframework.http.ResponseEntity;

@Builder
public class ErrorResponseEntity {
    private int status;
    private String code;
    private String message;

    public static ResponseEntity<ErrorResponseEntity> toResponse(ErrorCode e){
        return ResponseEntity.status(e.getHttpStatus())
                .body(
                        ErrorResponseEntity.builder()
                                .status(e.getHttpStatus().value())
                                .message(e.getMessage())
                                .code(e.name())
                                .build()
                );
    }


}

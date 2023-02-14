package com.application.todo.todos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodosResponseDto {
    private Long id;
    private String title;
    private Long todoOrder;
    private boolean completed;
}

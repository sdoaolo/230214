package com.application.todo.todos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodosRequestDto {
    private String title;

    @JsonProperty(value = "todo_order")
    private Long todoOrder;

    private Optional<Boolean> completed;

    public Optional<Boolean> getCompleted(){
        return this.completed;
    }

}

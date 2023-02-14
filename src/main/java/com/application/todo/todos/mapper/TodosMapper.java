package com.application.todo.todos.mapper;

import com.application.todo.todos.dto.TodosRequestDto;
import com.application.todo.todos.dto.TodosResponseDto;
import com.application.todo.todos.entity.Todos;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface TodosMapper {


    default Todos TodosRequestDtoToTodos(TodosRequestDto todosRequestDto){

        if ( todosRequestDto == null ) {
            return null;
        }

        Todos todos = new Todos();

        todos.setTitle( todosRequestDto.getTitle() );
        todos.setTodoOrder( todosRequestDto.getTodoOrder() );
        if ( todosRequestDto.getCompleted() != null ) {
            todos.setCompleted( todosRequestDto.getCompleted().get());
        }

        return todos;
    }

    TodosResponseDto TodosToTodosTodosResponseDto (Todos todos);

}

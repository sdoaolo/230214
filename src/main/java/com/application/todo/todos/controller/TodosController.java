package com.application.todo.todos.controller;

import com.application.todo.todos.dto.TodosRequestDto;
import com.application.todo.todos.dto.TodosResponseDto;
import com.application.todo.todos.entity.Todos;
import com.application.todo.todos.mapper.TodosMapper;
import com.application.todo.todos.service.TodosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin
public class TodosController {

    private final TodosService todosService;
    private final TodosMapper todosMapper;

    @PostMapping
    private ResponseEntity<TodosResponseDto> postTodos(@RequestBody TodosRequestDto todosRequestDto){
        Todos resultTodos = todosService.postTodos(todosMapper.TodosRequestDtoToTodos(todosRequestDto));
        TodosResponseDto responseDto = todosMapper.TodosToTodosTodosResponseDto(resultTodos);

        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("{id}")
    private ResponseEntity<TodosResponseDto> patchTodos(@PathVariable ("id") Long id,
                                                        @RequestBody TodosRequestDto todosRequestDto){
        Todos updateTodos = todosMapper.TodosRequestDtoToTodos(todosRequestDto);
        Todos resultTodos = todosService.patchTodos(updateTodos, id);
        TodosResponseDto responseDto = todosMapper.TodosToTodosTodosResponseDto(resultTodos);
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping("{id}")
    private ResponseEntity<TodosResponseDto> getTodos(@PathVariable ("id") Long id){
        Todos resultTodos = todosService.getTodos(id);
        return ResponseEntity.ok(todosMapper.TodosToTodosTodosResponseDto(resultTodos));
    }
    @GetMapping
    private ResponseEntity<?> getAllTodos(){
        List<Todos> allList = todosService.getAllTodos();
        if (allList.size() == 0) {
            return new ResponseEntity(
                    "To-do Application !",HttpStatus.OK); }
        return ResponseEntity.ok(allList);
    }
    @DeleteMapping("{id}")
    private ResponseEntity deleteTodos(@PathVariable ("id") Long id){
        todosService.deleteTodos(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    private ResponseEntity deleteAllTodos(){
        todosService.deleteAllTodo();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

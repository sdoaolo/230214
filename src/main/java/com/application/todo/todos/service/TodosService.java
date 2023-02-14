package com.application.todo.todos.service;

import com.application.todo.todos.entity.Todos;
import com.application.todo.todos.repository.TodosRepository;
import com.application.todo.todos.utils.CustomException;
import com.application.todo.todos.utils.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodosService {
    private final TodosRepository todosRepository;

    @Transactional
    public Todos postTodos(Todos todos){
        Todos savedTodos = todosRepository.save(todos);
        return savedTodos;
    }

    @Transactional
    public Todos patchTodos(Todos update, Long id){

        Todos todos = findVerifiedTodoWithId(id);

        if(update.getTitle() != null){
            todos.setTitle(update.getTitle());
        }
        if(update.getTodoOrder() != null){
            todos.setTodoOrder(update.getTodoOrder());
        }

        if(update.getCompleted()!= null){
            todos.setCompleted(update.getCompleted());
        }
        todos = todosRepository.save(todos);

        return todos;
    }

    @Transactional
    public Todos getTodos(Long id){
        return findVerifiedTodoWithId(id);
    }

    @Transactional
    public List<Todos> getAllTodos(){
        List<Todos> todoList = todosRepository.findAll();
        return todoList;
    }

    @Transactional
    public void deleteTodos(Long id){
        Todos findTodos = findVerifiedTodoWithId(id);
        todosRepository.delete(findTodos);
    }

    @Transactional
    public void deleteAllTodo(){
        todosRepository.deleteAll();
    }

    private Todos findVerifiedTodoWithId(Long id){
        Todos findTodos = todosRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return findTodos;
    }
}

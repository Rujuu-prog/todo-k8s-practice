package com.rujuu.todo.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rujuu.todo.repo.TodoRepository;
import com.rujuu.todo.model.Todo;;

@Service
public class TodoService {
    @Autowired
    private TodoRepository TodoRepository;

    private RestTemplate restTemplate;

    public TodoService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Todo> getAllTodos(){
        List<Todo> allTodos = new ArrayList<>();
        TodoRepository.findAll().forEach(allTodos::add);
        return allTodos;
    }

    public Optional<Todo> getTodo(Long todoId){
        return TodoRepository.findById(todoId);
    }

    public void addTodo(Todo todo){
        TodoRepository.save(todo);
    }

    public void updateTodo(Long todoId, Todo todo){
        if(TodoRepository.findById(todoId).get() != null){
            TodoRepository.save(todo);
        }
    }

    public void deleteTodo(Long todoId){
        TodoRepository.deleteById(todoId);
    }
}

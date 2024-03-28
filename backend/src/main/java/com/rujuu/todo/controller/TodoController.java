package com.rujuu.todo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.rujuu.todo.model.Todo;
import com.rujuu.todo.sevice.TodoService;


@RestController
public class TodoController {

    @Autowired
    private TodoService TodoService;

    @CrossOrigin(origins = "*")
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return TodoService.getAllTodos();
    }
    
}

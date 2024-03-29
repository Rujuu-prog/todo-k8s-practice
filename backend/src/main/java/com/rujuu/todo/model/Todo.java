package com.rujuu.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="m_todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    private String content;
    private Boolean done;

    public Todo(){
    }

    public Todo(String content, Boolean done) {
        this.content = content;
        this.done = done;
    }

    public Long getTodoId() {
        return todoId;
    }
    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Boolean getdone() {
        return done;
    }
    public void setdone(Boolean done) {
        this.done = done;
    }

    
}

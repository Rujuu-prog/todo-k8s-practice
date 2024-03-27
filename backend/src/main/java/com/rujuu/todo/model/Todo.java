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
    private Boolean checked;

    public Todo(){
    }

    public Todo(String content, Boolean checked) {
        this.content = content;
        this.checked = checked;
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
    public Boolean getChecked() {
        return checked;
    }
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    
}

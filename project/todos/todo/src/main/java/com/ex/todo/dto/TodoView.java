package com.ex.todo.dto;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="todo-view", types=Todo.class)
public interface TodoView {
    Integer getId();
    Boolean getDone();
    String getDescription();
    
}

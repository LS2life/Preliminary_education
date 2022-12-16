package com.ex.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ex.todo.dto.Todo;
import com.ex.todo.dto.TodoView;

@RepositoryRestResource (
		collectionResourceRel = "todos",
		path = "todos",
		excerptProjection = TodoView.class
		)
	@CrossOrigin
    public interface TodoRepository extends JpaRepository<Todo, Integer> {
        
    }

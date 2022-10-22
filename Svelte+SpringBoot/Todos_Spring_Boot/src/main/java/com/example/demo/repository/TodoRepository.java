package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dto.Todo;
import com.example.demo.dto.TodoView;

@RepositoryRestResource (
		collectionResourceRel = "todos",
		path = "todos",
		excerptProjection = TodoView.class
		)
	@CrossOrigin
	public interface TodoRepository extends JpaRepository<Todo, Integer> {
}

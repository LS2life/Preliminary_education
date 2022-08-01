package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.dto.Todo;

@RepositoryRestResource (collectionResourceRel = "todos", path = "todos")
	public interface TodoRepository extends JpaRepository<Todo, Integer> {
}

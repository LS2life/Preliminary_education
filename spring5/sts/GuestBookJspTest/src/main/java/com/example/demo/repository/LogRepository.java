package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Log;

public interface LogRepository 
	extends CrudRepository<Log, Integer> {

}

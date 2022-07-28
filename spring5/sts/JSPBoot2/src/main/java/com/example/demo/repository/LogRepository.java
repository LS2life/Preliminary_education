package com.example.demo.repository;

import com.example.demo.dto.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Log repository.
 */
public interface LogRepository extends JpaRepository<Log, Long>{
	

}

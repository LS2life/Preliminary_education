package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Log;
import com.example.demo.repository.LogRepository;

@Repository
public class LogDao {
	
	@Autowired
	private LogRepository logRepository;
	
	public void putLog(Log log) {
		logRepository.saveAndFlush(log);
	}

}

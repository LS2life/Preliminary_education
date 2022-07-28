package com.example.demo.dao;

import com.example.demo.dto.Log;
import com.example.demo.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The type Log dao.
 */
@Repository
public class LogDao {
	
	@Autowired
	private LogRepository logRepository;

	/**
	 * Put log log.
	 *
	 * @param log the log
	 * @return the log
	 */
	public Log putLog(Log log) {
		return logRepository.saveAndFlush(log);
	}
}

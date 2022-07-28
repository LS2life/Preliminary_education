package com.example.demo;

import com.example.demo.dao.LogDao;
import com.example.demo.dto.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Log test.
 */
@SpringBootTest
public class LogTest {

	/**
	 * The Log dao.
	 */
	@Autowired
	LogDao logDao;

	/**
	 * Test log.
	 */
	@Test
	void testLog(){
		Log log = new Log();
		log.setIp("test ip1");
		log.setMethod("put");
		log.setRegdate(new Date());
		Log savedLog=logDao.putLog(log);
		Log savedLog2=new Log();
		
		assertThat(log).isEqualTo(savedLog);
	}
}

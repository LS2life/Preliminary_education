package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.LogDao;
import com.example.demo.dto.Log;

@SpringBootTest
class LogDaoTest {
	
	@Autowired
	LogDao logDao;
	
	@Test
	void putLogTest() {
		Log log=new Log();
		log.setIp("127.0.0.1");
		log.setMethod("put");
		log.setRegdate(new Date());
		logDao.putLog(log);
	}

}

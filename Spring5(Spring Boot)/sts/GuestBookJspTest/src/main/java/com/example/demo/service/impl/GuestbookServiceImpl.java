package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.GuestbookDao;
import com.example.demo.dao.LogDao;
import com.example.demo.dto.Guestbook;
import com.example.demo.dto.Log;
import com.example.demo.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	
	@Autowired
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	@Transactional
	public List<Guestbook> getGuestbooks(Integer page) {
		return guestbookDao.getGuestbooksSome(
				page, GuestbookService.LIMIT);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteGuestbook(Long id, String ip) {
		guestbookDao.deleteGuestBook(id);
		Log log=new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.putLog(log);
	}

	@Override
	@Transactional(readOnly=false)
	public Guestbook putGuestbook(
			Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Guestbook sGuestbook=guestbookDao.putGuestbook(guestbook);
//		if(true) throw new RuntimeException("test");
		Log log=new Log();
		log.setIp(ip);
		log.setMethod("put");
		log.setRegdate(new Date());
		logDao.putLog(log);
		return sGuestbook;
	}

	@Override
	public int getGuestbooksSize() {
		return guestbookDao.getGuestbooksSize().intValue();
	}

}

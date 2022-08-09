package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.example.demo.dao.GuestbookDao;
import com.example.demo.dto.Guestbook;

@SpringBootTest
class GuestbookDaoTests {
	@Autowired
	GuestbookDao guestbookDao;
	
	@Test
	void testGuestbookDao() {
//		List<Guestbook> guestbooks=guestbookDao.getGuestbooks();
//		for(Guestbook guestbook:guestbooks) {
//			System.out.println(guestbook);
//		}
		
		List<Guestbook> guestbooks=guestbookDao.getGuestbooksSome(0,5);
		for(Guestbook guestbook:guestbooks) {
			System.out.println(guestbook);
		}
		
//		Long getCount=Long.valueOf(guestbooks.size());
//		assertThat(getCount).isEqualTo(guestbookDao.getGuestbooksSize());
		
//		Guestbook guestbook=new Guestbook();
//		guestbook.setName("testName");
//		guestbook.setRegdate(new Date());
//		guestbook.setContent("testContent");
//		guestbookDao.putGuestbook(guestbook);
		
//		for(int i=0;i<10;i++) {
//			Guestbook guestbook=new Guestbook();
//			guestbook.setName("testName"+i);
//			guestbook.setRegdate(new Date());
//			guestbook.setContent("testContent"+i);
//			guestbookDao.putGuestbook(guestbook);
//		}
		
//		guestbookDao.deleteGuestBook(15L);
//		Long gSize=guestbookDao.getGuestbooksSize();
//		System.out.println(gSize);
	}

}

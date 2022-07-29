package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.Guestbook;
import com.example.demo.service.impl.GuestbookServiceImpl;

@SpringBootTest
public class GBServiceTest {
	
	@Autowired
	GuestbookServiceImpl guestbookServiceImpl;
	
	@Test
	void testGBS() {
//		for(Guestbook g:guestbookServiceImpl.getGuestbooks(0)) {
//			System.out.println(g);
//		}
//		guestbookServiceImpl.deleteGuestbook(8L, "localhost");
//		Guestbook guestbook=new Guestbook();
//		guestbook.setName("S_impl_test_name1");
//		guestbook.setContent("S_impl_test_content1");
//		guestbook.setRegdate(new Date());
//		guestbookServiceImpl.putGuestbook(
//				guestbook, "S_impl_test_ip1");
		Guestbook guestbook=new Guestbook();
		guestbook.setName("transaction_test_name1");
		guestbook.setContent("transaction_test_content1");
		guestbook.setRegdate(new Date());
		guestbookServiceImpl.putGuestbook(
				guestbook, "transaction_test_ip1");
	}
	
}

package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.GuestbookDao;
import com.example.demo.dto.Guestbook;

@SpringBootTest
public class GBT {
	@Autowired
	GuestbookDao guestbookDao;
	
	@Test
	void testGBD() {
		//guestbook dao put test
//		Guestbook guestbook=new Guestbook();
//		guestbook.setContent("test content3");
//		guestbook.setName("test name3");
//		guestbook.setRegdate(new Date());
//		guestbookDao.putGuestbook(guestbook);
		
//		for(int i=0;i<30;i++) {
//			Guestbook guestbook=new Guestbook();
//			guestbook.setContent("test content"+i);
//			guestbook.setName("test name"+i);
//			guestbook.setRegdate(new Date());
//			guestbookDao.putGuestbook(guestbook);
//		}
//		for(Guestbook gb:guestbookDao.getGuestbooks()) {
//			System.out.println(gb);
//		}
		for(Guestbook gb:guestbookDao.getGuestbooksSome(0,5)) {
			System.out.println(gb);
		}
//		List<Guestbook> guestbooks=guestbookDao.getGuestbooks();
//		Long totalSize=guestbookDao.getGuestbookSize();
//		System.out.println("totalSize: "+totalSize);
//		System.out.println(guestbooks.size());
//		assertThat(guestbooks.size()).isEqualTo(totalSize.intValue());
//		Long totalSize1=guestbookDao.getGuestbookSize();
//		guestbookDao.deleteGuestbook(43L);
//		Long totalSize2=guestbookDao.getGuestbookSize();
//		assertThat(totalSize1-1).isEqualTo(totalSize2);
	}

}

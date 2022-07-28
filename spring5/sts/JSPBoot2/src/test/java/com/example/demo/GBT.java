package com.example.demo;

import com.example.demo.dao.GuestbookDao;
import com.example.demo.dto.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * The type Gbt.
 */
@SpringBootTest
public class GBT {

	/**
	 * The Guestbook dao.
	 */
	@Autowired
	GuestbookDao guestbookDao;

	/**
	 * Test gbd.
	 */
	@Test
	void testGBD() {
//		//put test
//		Guestbook guestbook=new Guestbook();
//		guestbook.setContent("test content1");
//		guestbook.setName("test name1");
//		guestbook.setRegdate(new Date());
//		guestbookDao.putGuestbook(guestbook);
		
		//put test 30EA
//		for(int i=0;i<30;i++) {
//		Guestbook guestbook2=new Guestbook();
//		guestbook2.setContent("test content"+i);
//		guestbook2.setName("test name"+i);
//		guestbook2.setRegdate(new Date());
//		guestbookDao.putGuestbook(guestbook2);
//	}
			
//		for(Guestbook gb:guestbookDao.getGuestbooks()) {
//			System.out.println(gb);
//		}

//		for(Guestbook gb:guestbookDao.getGuestbooks(1,5)) {
//			System.out.println(gb);
//		}
		
		List<Guestbook> guestbooks=guestbookDao.getGuestbooks();
		Long totalSize=guestbookDao.getGuestbookSize();
		System.out.println("totalSize: "  +totalSize);
		System.out.println(guestbooks.size());
		assertThat(guestbooks.size()).isEqualTo(totalSize.intValue());
		
//		Long totalSize1=guestbookDao.getGuestbookSize();
//		guestbookDao.deleteGuestbook(44L);
	}
	
}

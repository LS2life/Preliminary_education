package com.home.page;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.home.page.ttk.Board;

@SpringBootTest
class PageApplicationTests {

	@Test
	public void testToString() {
		Board board = new Board();

		System.out.println(board);
	}

}

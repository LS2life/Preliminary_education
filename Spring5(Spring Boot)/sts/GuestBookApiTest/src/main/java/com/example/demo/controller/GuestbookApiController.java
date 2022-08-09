package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Guestbook;
import com.example.demo.repository.GuestbookRepository;

@RestController
public class GuestbookApiController {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@PostMapping(path="/guestbooks")
	public @ResponseBody String putGuestbook(
			@RequestBody Guestbook guestbook
			) {
		guestbook.setRegdate(new Date());
		guestbookRepository.save(guestbook);
		return "Saved";
	}
}

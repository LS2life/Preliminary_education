package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Guestbook;
import com.example.demo.repository.GuestbookRepository;

@Repository
public class GuestbookDao {
	
	@Autowired
	private GuestbookRepository guestbookRepostory;
	
	public Guestbook putGuestbook(Guestbook guestbook) {
		return guestbookRepostory.saveAndFlush(guestbook);
	}
	
	public List<Guestbook> getGuestbooks(){
		return guestbookRepostory.findAll();
	}
	
	public List<Guestbook> getGuestbooksSome( Integer page,Integer limit) {
		Pageable pageable=PageRequest.of(
				page, limit,Sort.by("id").descending());
		return guestbookRepostory.findAll(pageable).getContent();
	}
	
	public Long getGuestbookSize() {
		return guestbookRepostory.count();
	}
	
	public void deleteGuestbook(Long id) {
		guestbookRepostory.deleteById(id);
	}

}

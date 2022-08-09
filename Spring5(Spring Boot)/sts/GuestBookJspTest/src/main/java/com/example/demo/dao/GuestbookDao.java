package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Guestbook;
import com.example.demo.repository.GuestbookRepository;

@Repository
public class GuestbookDao {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	public Guestbook putGuestbook(Guestbook guestbook) {
		return guestbookRepository.saveAndFlush(guestbook);
	}
	
	public List<Guestbook> getGuestbooks() {
		List<Guestbook> guestbooks=new ArrayList();
		guestbookRepository.findAll()
			.forEach(o->guestbooks.add(o));
		return guestbooks;
	}
	
	public List<Guestbook> getGuestbooksSome(
			Integer page,Integer limit) {
//		PageRequest pageRequest=PageRequest.of(page, limit);
//		List<Guestbook> guestbooks=new ArrayList();
//		guestbookRepository.findAll(pageRequest)
//		.forEach(o->guestbooks.add(o));
//		return guestbooks;
		Pageable pageable=PageRequest.of(page, limit,Sort.by("id").descending());
		return guestbookRepository.findAll(pageable).getContent();
	}
	
	public Long getGuestbooksSize() {
		return guestbookRepository.count();
	}
	
	public void deleteGuestBook(Long id) {
		guestbookRepository.deleteById(id);
	}

}

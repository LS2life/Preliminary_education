package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Guestbook;

public interface GuestbookRepository 
	extends CrudRepository<Guestbook, Integer> {

}

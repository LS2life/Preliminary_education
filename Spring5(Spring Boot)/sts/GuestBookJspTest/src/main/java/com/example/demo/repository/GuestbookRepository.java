package com.example.demo.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Guestbook;

public interface GuestbookRepository 
	extends JpaRepository<Guestbook, Long> {
	
}

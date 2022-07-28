package com.example.demo.repository;

import com.example.demo.dto.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Guestbook repository.
 */
public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
	

		
}

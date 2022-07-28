package com.example.demo.dao;

import com.example.demo.dto.Guestbook;
import com.example.demo.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Guestbook dao.
 */
@Repository
public class GuestbookDao {


	@Autowired
	private GuestbookRepository guestbookRepository;

	/**
	 * Put guestbook guestbook.
	 *
	 * @param guestbook the guestbook
	 * @return the guestbook
	 */
	public Guestbook putGuestbook(Guestbook guestbook) {
		return guestbookRepository.saveAndFlush(guestbook);
	}

	/**
	 * Get guestbooks list.
	 *
	 * @return the list
	 */
	public List<Guestbook> getGuestbooks(){
		return guestbookRepository.findAll();
	}

	/**
	 * Gets guestbooks some.
	 *
	 * @param page  the page
	 * @param limit the limit
	 * @return the guestbooks some
	 */
	public List<Guestbook> getGuestbooksSome(Integer page, Integer limit) {

		PageRequest pageRequest=PageRequest.of(page, limit);
		List<Guestbook> guestbooks=new ArrayList();
		guestbookRepository.findAll(pageRequest).forEach(g->guestbooks.add(g));

		return guestbooks;
	}

	/**
	 * Gets guestbook size.
	 *
	 * @return the guestbook size
	 */
	public Long getGuestbookSize() {
		return guestbookRepository.count();
	}

	/**
	 * Delete guestbook.
	 *
	 * @param id the id
	 */
	public void deleteGuestbook(Long id) {
		guestbookRepository.deleteById(id);
	}

}

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.Guestbook;
import com.example.demo.service.GuestbookService;

@Controller
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path="/list")
	public String list(
			@RequestParam(name="page",defaultValue="0")
			int page,
			ModelMap model
			) {
//		System.out.println("page: "+page);
		List<Guestbook> list=guestbookService.getGuestbooks(page);
		int count=guestbookService.getGuestbookSize();
		//paging
		//전체 페이지 수=총게시물/한 페이지 수->나머지 0 else +1
		int pageCount=count/GuestbookService.LIMIT;
		if(count%GuestbookService.LIMIT>0) {
			pageCount+=1;
		}
		List<Integer> pageList=new ArrayList<>();
		for(int i=0;i<pageCount;i++) {
			pageList.add(i);
		}
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageList", pageList);
		return "list";
	}
	
	@PostMapping(path="/write")
	public String write(
			@ModelAttribute Guestbook guestbook,
			HttpServletRequest request) {
		String clientIp=request.getRemoteAddr();
//		System.out.println(clientIp);
//		System.out.println(guestbook);
		guestbookService.putGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
	
	
}

package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

	@GetMapping(value="/hi")

	public String niceToMeetYou(Model model) {
		model.addAttribute("username","일신우일신");
		return "greetings";
	}

	@GetMapping("/bye")
	public String seeYouNext(Model model) {
		model.addAttribute("nickname","상수");
		return "goodbye";
	}
	
}

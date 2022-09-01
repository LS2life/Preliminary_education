package io.github.ls2life.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
		
	@GetMapping("home")
	public String mainHome() {
		
		return "index";
	}
}

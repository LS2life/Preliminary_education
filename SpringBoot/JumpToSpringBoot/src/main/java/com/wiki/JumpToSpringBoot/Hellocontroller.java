package com.wiki.JumpToSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hellocontroller {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}

}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	
	//localhost(127.0.0.1):8080
	@GetMapping(path="/plusform")
	public String plusform() {
		return "plusForm";
	}
	
	@GetMapping(path="/plus")
	public String plus(
			@RequestParam(name="value1") int value1,
			@RequestParam(name="value2") int value2,
			ModelMap modelMap
			) {
//		System.out.println(value1);
//		System.out.println(value2);
		int result=value1+value2;
		modelMap.addAttribute("value1",value1);
		modelMap.addAttribute("value2",value2);
		modelMap.addAttribute("result",result);
		return "plusResult";
	}
	@PostMapping(path="/plus")
	public String plusPost(
			@RequestParam(name="value1") int value1,
			@RequestParam(name="value2") int value2,
			ModelMap modelMap
			) {
		int result=value1+value2;
		modelMap.addAttribute("value1",value1);
		modelMap.addAttribute("value2",value2);
		modelMap.addAttribute("result",result);
		return "plusResult";
	}
}

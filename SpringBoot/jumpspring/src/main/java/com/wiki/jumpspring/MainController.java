package com.wiki.jumpspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	// ip address 다음 주소
	@RequestMapping("/jumpspring")

    // URL 요청에대한 응답으로 문자열을 리턴하라는 의미
    // 생략시 index라는 이름의 템플릿파일을 찾는다.
	@ResponseBody
	public String index() {
		return "안녕하세요 저의 홈페이지에 오신것을 환영합니다.";
	}

	@RequestMapping("/")
	public String root() {
		// redirect:<URL> URL로 리다이렉트(새로고침 URL로 요청). 
		// forward:<URL> URL로 포워드(기존 요청값이 유지된채로 URL 전환.)
		// 루트로 진입시 바로 /question/list 주소로 보내버림
		return "redirect:/question/list";
	}
}

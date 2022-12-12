package com.wiki.jumpspring.Question;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.wiki.jumpspring.Answer.AnswerForm;
import com.wiki.jumpspring.user.SiteUser;
import com.wiki.jumpspring.user.UserService;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.RequiredArgsConstructor;

// 의존성 주입(Dependency Injection) 방식 3가지
// 생성자 - 생성자를 작성하여 객체를 주입하는 방식(권장)
// Setter - Setter 메소드를 작성하여 @Autowired로 객체를 주입하는 방식.

// URL 접두사(prefix)가 동일한부분은 선맵핑으로 처리 할 수 있다.ㅇ
@RequestMapping("/question")
// 롬복이 제공하는 어노테이션으로 final이 붙은 속성을 포함하여 생성자를 자동으로 생성하는 역할을 한다.
// questionRepository 객채가 자동으로 주입된다.
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;
	private final UserService userService;
	
	// URL 메핑시 value 매개변수는 생략할 수 있다.
	@RequestMapping("/list")
	// Model 객체는 자바클래스와 템플릿 간의 연결고리 역할을 한다. 따로 생성할 필요없이
	// 컨트롤러 메서드의 매개변수로 지정하기만 하면 스프링부트가 자동으로 Model 객체를 생성한다.
	// public String list(Model model,@RequestParam(value="page", defaultValue="0")int page) {
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
		// Page<Question> paging = this.questionService.getList(page);
        Page<Question> paging = this.questionService.getList(page, kw);
		model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
		return "question_list";
	}

	// 변하는 id값을 얻을 때 @PathVariable 어노테이션을 사용해야한다. 
	// 리퀘스트 멥핑값(id)과 매개변수값(id)이 동일해야한다.
	@RequestMapping(value = "detail/{id}")
	// public String detail(Model model, @PathVariable("id") Integer id) {
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create")
	// public String questionCreate() {
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}


	@PreAuthorize("isAuthenticated()")
	// Getmapping에서 사용했던 메소드명과 동일하게 사용할 수 있지만 매개변수의 형태가 다른경우에만 가능하다.(메소드 오버로딩은 가능하다.)
	@PostMapping("/create")
	// public String questionCreate(@RequestParam String subject, @RequestParam String content) {
	// @Valid 사용시 QuestionForm의 @Notempty,@Size등으로 설정한 검증기능 동작.
	// BindingResult 매개변수는 @Valid 로 검증이 수행된 결과를 의미하는 객체이다.
	public String questionCreate(@Valid QuestionForm questionForm,BindingResult bindingResult,Principal principal) {
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		SiteUser siteUser = this.userService.getUser(principal.getName());
		// this.questionService.create(subject,content);
		// subject, content 항목이 전송된면 QuestionForm에서 자동으로 바인딩.
		this.questionService.create(questionForm.getSubject(),questionForm.getContent(), siteUser);
		return "redirect:/question/list";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
		Question question = this.questionService.getQuestion(id);
		if(!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		questionForm.setSubject(question.getSubject());
		questionForm.setContent(question.getContent());
		return "question_form";
	}

	// 질문 수정화면에서 질문의 제목이나 내용을 변경하고 '저장하기' 버튼을 누르면 호출되는 POST요청 처리.
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal, @PathVariable("id") Integer id) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		Question question = this.questionService.getQuestion(id);
		if (!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
		return String.format("redirect:/question/detail/%s",id);
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{id}")
	public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		if(!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"삭제권한이 없습니다.");
		}
		this.questionService.delete(question);
		return "redirect:/";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/vote/{id}")
	public String questionVote(Principal principal, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		this.questionService.vote(question, siteUser);
		return String.format("redirect:/question/detail/%s", id);
	}

	
}

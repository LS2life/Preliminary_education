package com.ex.ssg.question;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.ssg.answer.AnswerForm;

import lombok.RequiredArgsConstructor;

// 의존성 주입(Dependency Injection) 방식 3가지
// 생성자 - 생성자를 작성하여 객체를 주입하는 방식(권장)
// Setter - Setter 메소드를 작성하여 @Autowired로 객체를 주입하는 방식.

// log객체를 사용하여 debug,error 등의 로그를 출력할 수 있다.
// trace (1단계) - debug 보다 훨씬 상세한 정보를 나타낼 경우에 사용
// debug (2단계) - 디버깅 목적으로 사용
// info  (3단계) - 일반 정보를 출력할 목적으로 사용
// warn  (4단계) - 경고 정보를 출력할 목적으로(작은 문제) 사용
// error (5단계) - 오류 정보를 출력할 목적으로(큰 문제) 사용
// fatal (6단계) - 아주 심각한 문제를 출력할 목적으로 사용

// URL 접두사(prefix)가 동일한부분은 선맵핑으로 처리 할 수 있다.
@RequestMapping("/question")
// 롬복이 제공하는 어노테이션으로 final이 붙은 속성을 포함하여 생성자를 자동으로 생성하는 역할을 한다.
// questionRepository 객채가 자동으로 주입된다.
@RequiredArgsConstructor
@Controller
public class QuestionController {

    // private final QuestionRepository questionRepository;
    private final QuestionService questionsService;

    // URL 메핑시 value 매개변수는 생략할 수 있다.
    @GetMapping("/list")
    // Model 객체는 자바클래스와 템플릿 간의 연결고리 역할을 한다. 따로 생성할 필요없이
	// 컨트롤러 메서드의 매개변수로 지정하기만 하면 스프링부트가 자동으로 Model 객체를 생성한다.
    // JSP Servlet으로 웹 어플리케이션을 만들때 보통 request나 session 내장객체에 정보를 담아 jsp에 넘겨주곤 하는데 Spring에서는 Model이 request.setAttribute()와 비슷한 역할을 한다.
    public String list(Model model, @RequestParam(value="page", defaultValue="0")int page) {
        // List<Question> questionList = this.questionsService.getList();
        Page<Question> paging = this.questionsService.getList(page);
        model.addAttribute("paging",paging);
        return "question_list";
    }
    
    // 변하는 id값을 얻을 때 @PathVariable 어노테이션을 사용해야한다. 
	// 리퀘스트 멥핑값(id)과 매개변수값(id)이 동일해야한다.
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionsService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
    
    @PostMapping("/create")
    // public String questionCreate(@RequestParam String subject, @RequestParam String content) {
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "question_form";
        }
        // this.questionService.create(subject, content);
        this.questionsService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}

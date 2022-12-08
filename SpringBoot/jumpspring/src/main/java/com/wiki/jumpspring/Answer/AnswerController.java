package com.wiki.jumpspring.Answer;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wiki.jumpspring.Question.Question;
import com.wiki.jumpspring.Question.QuestionService;
import com.wiki.jumpspring.user.SiteUser;
import com.wiki.jumpspring.user.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

	@PreAuthorize("isAuthenticated()")
    // id는 질문 id. 조회후 없다면 404오류 발생
    @PostMapping("/create/{id}")
    // @RequestParam은 텍스트에이리어의 name 속성명이 content이기때문에 여기서도 변수명을 그대로 사용해야한다. 다르면 오류발생.
    // public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
    public String createAnswer (
        Model model,
        @PathVariable("id") Integer id,
        @Valid AnswerForm answerForm,
        BindingResult bindingResult,
        Principal principal) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("question",question);
            return "question_detail";
        }
        // this.answerService.create(question,content);
        this.answerService.create(question, answerForm.getContent(),siteUser);
        return String.format("redirect:/question/detail/%s", id);
    }
}

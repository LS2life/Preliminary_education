package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blog.Repository.ArticleRepository;
import com.example.blog.dto.ArticleForm;
import com.example.blog.entity.Article;

import lombok.extern.slf4j.Slf4j;

@Controller
// 로깅을 위한 어노테이션
@Slf4j
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해 놓은 객체를 가져다가 자동 연결.
    private ArticleRepository articleRepository;
    
    @GetMapping("/articles/body")
    public String newArticleForm(){
        return "articles/body";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){ 
        log.info(form.toString());

        // System.out.println(form.toString()); -> 로깅기능으로 대체함.

        // 1. Dto를 Entity로 변환.
        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.println(article.toString());

        // 2. Repository에게 Entity를 DB로 저장하도록 명령.
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // System.out.println(saved.toString());

        return "";
    }

    
}

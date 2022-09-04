package com.esanfield.playground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    
    @GetMapping("/home")
    public String newArticleForm() {
        return "/src/main/resources/templates/index.html";
    }
}

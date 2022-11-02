package com.example.blog.dto;

import com.example.blog.entity.Article;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }

    // @AllArgsConstructor로 아래 구문을 넣은 것과 같은 기능을 적용할 수 있다.
    // public ArticleForm(String title, String content) {
    //     this.title = title;
    //     this.content = content;
    // }

    // ToString 으로 아래 구문을 넣은 것과 같은 기능을 적용할 수 있다.
    // @Override
    // public String toString() {
    //     return "ArticleForm{"
    //     + "title='" + title +'\'' 
    //     +", content='" + content +'\''
    //     +'}';
    // }

}

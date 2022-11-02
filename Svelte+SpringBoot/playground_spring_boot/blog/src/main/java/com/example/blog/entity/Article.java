package com.example.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// DB가 해당 객체를 인식 가능
@Entity
public class Article {

    // 대표값
    @Id
    // 대표값자동생성
    @GeneratedValue
    private Long id;
    
    // 테이블단위의 칼럼
    @Column
    private String title;

    @Column
    private String content;

    // 소스>생성자로 생성.
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // 소스 > toString()으로 생성.
    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }

    
}

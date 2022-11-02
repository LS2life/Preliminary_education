package com.example.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.ToString;

// DB가 해당 객체를 인식 가능
@Entity
@AllArgsConstructor
@ToString
public class Article {

    // 대표값
    @Id
    // 대표값 번호를 자동생성 
    @GeneratedValue
    private Long id;
    
    // 테이블단위의 칼럼
    @Column
    private String title;

    @Column
    private String content;

    // AllArgsConstructor 적용하여 생략.
    // 소스>생성자로 생성.
    // public Article(Long id, String title, String content) {
    //     this.id = id;
    //     this.title = title;
    //     this.content = content;
    // }

    // @ToString 적용하여 생략.
    // 소스 > toString()으로 생성.
    // @Override
    // public String toString() {
    //     return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    // }
}

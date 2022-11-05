package com.example.blog.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.blog.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long>{
    
}

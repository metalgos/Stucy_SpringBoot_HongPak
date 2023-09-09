package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {


    @Autowired // 객체 주입
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        System.out.println(form.toString());
        //1.dto 를 엔티티로변환!!
        Article article = form.toEntity();
        System.out.println(article.toString());

        //2.repository에게 엔티티들 디비에 저장

       Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }

}

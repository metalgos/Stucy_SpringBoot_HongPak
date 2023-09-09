package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j//로깅을 위한 어노테이션
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

        //System.out.println(form.toString()); 로깅으로 대채

        log.info(form.toString());
        //1.dto 를 엔티티로변환!!
        Article article = form.toEntity();
        log.info(article.toString());

        //2.repository에게 엔티티들 디비에 저장

       Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "";
    }

}

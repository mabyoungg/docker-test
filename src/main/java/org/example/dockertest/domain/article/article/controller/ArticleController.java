package org.example.dockertest.domain.article.article.controller;

import lombok.RequiredArgsConstructor;
import org.example.dockertest.domain.article.article.entity.Article;
import org.example.dockertest.domain.article.article.repository.ArticleRepository;
import org.example.dockertest.domain.article.article.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/")
    @ResponseBody
    public String showMain() {
        return "메인";
    }

    @GetMapping("/new")
    @ResponseBody
    public Article newArticle() {
        Article article = articleService.save("제목");

        return article;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Article> articles() {
        return articleService.findAll();
    }
}

package org.example.dockertest.domain.article.article.service;

import lombok.RequiredArgsConstructor;
import org.example.dockertest.domain.article.article.entity.Article;
import org.example.dockertest.domain.article.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article save(String title) {
        return articleRepository.save(new Article(title));
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}

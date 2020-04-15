package com.tvn24.tvn24.controller;

import com.tvn24.tvn24.domain.Article;
import com.tvn24.tvn24.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleController {


    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(path = "/article/add")
    public String addArticle(@RequestBody @Valid Article article) {
        return articleService.addArticle(article);
    }

    @PostMapping(path = "/article/addMany")
    public String addArticles(@RequestBody @Valid List<Article> articles) {
        return articleService.addArticles(articles);
    }

    @GetMapping(path = "/article/all")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping(path = "/article/tag/{tag}")
    public List<Article> getArticlesByTag(@PathVariable String tag) {
    return articleService.getArticlesByTag(tag);
    }
}

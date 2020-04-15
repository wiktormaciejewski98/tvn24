package com.tvn24.tvn24.service;

import com.tvn24.tvn24.domain.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    List<Article> articlesDb = new ArrayList<>();

    public String addArticle(Article article) {
        articlesDb.add(article);
        return "Article " + article.getTitle() + " has been added.";
    }

    public List<Article> getAllArticles() {
        return articlesDb;
    }

    public List<Article> getArticlesByTag(String tag) {
        return articlesDb.stream()
                .filter(article -> article.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    public String addArticles(List<Article> articles) {
        articlesDb.addAll(articles);
        return articles.size() + " articles have been added.";
    }
}

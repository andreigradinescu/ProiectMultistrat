package com.onlineshop.multistrat.services;

import com.onlineshop.multistrat.entities.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleServices {

    List<Article> findAll();

    Optional<Article> find(Long id);

    Long create(Article article);

    Long updateById(Long id, Article article);

    void delete(Long id);

}

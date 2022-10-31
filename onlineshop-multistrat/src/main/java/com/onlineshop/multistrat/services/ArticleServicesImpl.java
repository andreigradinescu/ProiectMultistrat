package com.onlineshop.multistrat.services;

import com.onlineshop.multistrat.entities.Article;
import com.onlineshop.multistrat.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServicesImpl implements ArticleServices{

    private final ArticleRepository articleRepository;

    public ArticleServicesImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        List<Article> articleList = new ArrayList<> ();

        articleRepository.findAll().forEach(articleList::add);
        return articleList;
    }

    @Override
    public Optional<Article> find(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Long create(Article article) {
        return articleRepository.save(article).getId();
    }

    @Override
    public Long updateById(Long id, Article article) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()){
            return articleRepository.save(article).getId();
        } else {
            System.out.println("Something went wrong!");
        }
        return id;

    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}

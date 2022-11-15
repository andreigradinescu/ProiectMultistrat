package com.onlineshop.multistrat.services;

import com.onlineshop.multistrat.entities.Article;
import com.onlineshop.multistrat.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            return articleRepository.findById(id);
        }else {
            throw new NoSuchElementException("Nu exista articolul cu id:" + id);
        }
    }

    @Override
    public Long create(Article article) {
        return articleRepository.save(article).getId();
    }

    @Override
    public Long updateById(Long id, Article article) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()){
            article.setId(id);
            return articleRepository.save(article).getId();
        } else {
            throw new NoSuchElementException("Nu exista articolul cu id:" + id);
        }


    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}

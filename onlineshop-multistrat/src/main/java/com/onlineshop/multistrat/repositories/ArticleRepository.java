package com.onlineshop.multistrat.repositories;

import com.onlineshop.multistrat.entities.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {


}

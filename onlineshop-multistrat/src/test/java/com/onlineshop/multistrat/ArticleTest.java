package com.onlineshop.multistrat;

import com.onlineshop.multistrat.entities.Article;
import com.onlineshop.multistrat.repositories.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.PersistenceContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ArticleTest {

    @Mock
    private TestEntityManager entityManager;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testCreateNewArticle(){
        Article newArticle;
        newArticle = new Article("bluza albastra", "Jichael Mackson", new BigDecimal(199), "photo_url");

        Article savedArticle =  articleRepository.save(newArticle);
        assertThat(savedArticle.getId()).isGreaterThan(0);
    }

}


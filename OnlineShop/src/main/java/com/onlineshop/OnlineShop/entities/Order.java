package com.onlineshop.OnlineShop.entities;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name = "userId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Id
    @Column(name = "articleId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(length = 12, nullable = false)
    @NonNull
    private BigDecimal cashAmount;

    @Column(length = 12, nullable = false)
    @NonNull
    private Integer units;

    public void addArticle(){

        return;
    }
}



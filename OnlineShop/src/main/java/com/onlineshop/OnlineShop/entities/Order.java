package com.onlineshop.OnlineShop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Id
    @Column(name = "userId", nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // @Id
    @Column(name = "articleId", nullable = false)
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(length = 12, nullable = false)
    @NotNull
    @Positive
    private BigDecimal cashAmount;

    @Column(length = 12, nullable = false)
    @NotNull
    private Integer units;

//    public void addArticle(){
//
//        return;
//    }
}



package com.onlineshop.multistrat.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false, name = "article_name")
    @NonNull
    private String name;

    @Column(length = 512, nullable = false)
    @NonNull
    private String description;

    @Column(length = 16, nullable = false)
    @NonNull
    private BigDecimal price;

    @Column(length = 64, name = "photo_url")
    private String photo;




}

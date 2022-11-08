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
@Table(name = "articles")
public class Article implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false, name = "article_name")
    @NonNull
    private String name;

    @Column(length = 512, nullable = false, name = "description")
    @NonNull
    private String description;

    @Column(length = 16, nullable = false, name = "price")
    @NonNull
    private BigDecimal price;

    @Column(length = 64, name = "photo_url")
    private String photo;

    public Article(String name, String description, BigDecimal price, String photo){
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                '}';
    }
}

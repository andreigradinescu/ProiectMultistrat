package com.onlineshop.OnlineShop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    private Long orderId;
    private Long userId;
    private Long articleId;
    private Float subTotal;
}



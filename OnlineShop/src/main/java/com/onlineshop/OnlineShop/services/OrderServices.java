package com.onlineshop.OnlineShop.services;

import com.onlineshop.OnlineShop.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderServices {
    List<Order> findAll();

    Optional<Order> find(Long id);

    Long create(Order order);

    Long updateById(Long id, Order order);

    void delete(Long id);
}

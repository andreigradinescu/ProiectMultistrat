package com.onlineshop.OnlineShop.repositories;

import com.onlineshop.OnlineShop.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> getOrderListByUserId(Long userId,Order order);

}

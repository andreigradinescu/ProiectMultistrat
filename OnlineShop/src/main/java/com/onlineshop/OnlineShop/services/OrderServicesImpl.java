package com.onlineshop.OnlineShop.services;

import com.onlineshop.OnlineShop.entities.Order;
import com.onlineshop.OnlineShop.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServicesImpl implements OrderServices {
    private final OrderRepository orderRepository;

    public OrderServicesImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> find(Long id) {
        return Optional.empty();
    }

    @Override
    public Long create(Order order) {
        return null;
    }

    @Override
    public Long updateById(Long id, Order order) {
        return null;
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);

    }
}

package com.onlineshop.OnlineShop.services;

import com.onlineshop.OnlineShop.entities.Order;
import com.onlineshop.OnlineShop.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Order> orderList = new ArrayList<>();

        orderRepository.findAll().forEach(orderList::add);
        return orderList;
    }

    @Override
    public Optional<Order> find(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Long create(Order order) {
        return orderRepository.save(order).getId();
    }

    @Override
    public Long updateById(Long id, Order order) {
        Optional<Order>  orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()){
            order.setId(id);
            return orderRepository.save(order).getId();
        } else {
            System.out.println("Something went wrong!");
        }
        return id;
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);

    }
}

package com.onlineshop.OnlineShop.repositories;
import com.onlineshop.OnlineShop.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <Order, Long>{

}

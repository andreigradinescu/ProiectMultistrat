package com.onlineshop.multistrat.chelariu.services;

import com.onlineshop.multistrat.chelariu.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserServices {

    List<User> findAll();

    Optional<User> find(Long id);

    Long create(User user);

    Long updateById(Long id, User user);

    void delete(Long id);


}

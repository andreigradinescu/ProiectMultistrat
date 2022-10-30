package com.onlineshop.multistrat.chelariu.services;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import com.onlineshop.multistrat.chelariu.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserServices {
//User
    List<User> findAll();

    Optional<User> find(Long id);

    Long create(User user);

    Long updateById(Long id, User user);

    void delete(Long id);

    void encodePassword(User user);
//Role
    List<Rol> listRole();

}

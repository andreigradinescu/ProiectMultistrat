package com.onlineshop.multistrat.chelariu.repositories;

import com.onlineshop.multistrat.chelariu.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

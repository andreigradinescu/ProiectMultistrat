package com.onlineshop.multistrat.chelariu.repositories;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Rol, Long> {

}

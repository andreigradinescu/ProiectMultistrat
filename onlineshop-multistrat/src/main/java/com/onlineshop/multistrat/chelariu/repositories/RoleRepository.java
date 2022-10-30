package com.onlineshop.multistrat.chelariu.repositories;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
}

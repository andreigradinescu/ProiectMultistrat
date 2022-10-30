package com.onlineshop.multistrat.chelariu.controllers;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import com.onlineshop.multistrat.chelariu.services.UserServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {

    private final UserServices userServices;

    public RoleController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/")
    public List<Rol> find() {
        return userServices.listRole ();
    }
}

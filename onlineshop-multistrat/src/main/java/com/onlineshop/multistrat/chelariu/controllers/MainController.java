package com.onlineshop.multistrat.chelariu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }
}

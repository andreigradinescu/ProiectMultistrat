package com.onlineshop.multistrat.chelariu.controllers;

import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.services.UserServices;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> findAll(){
      return userServices.findAll ();
    }

    @GetMapping("/{id}")
    public Optional<User> find(@PathVariable("id") @NotNull Long id){
        return userServices.find (id);

    }

    @PostMapping
    public Long User(@RequestBody User user) {
        return userServices.create (user);
    }

    @PutMapping("/{id}")
    public Long User(@PathVariable("id") Long id, @Valid @RequestBody User user) {
        return userServices.updateById (id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") @NotNull Long id) {
        userServices.delete (id);
    }
}

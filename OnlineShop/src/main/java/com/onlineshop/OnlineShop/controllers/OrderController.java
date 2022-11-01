package com.onlineshop.OnlineShop.controllers;

import com.onlineshop.OnlineShop.entities.Order;
import com.onlineshop.OnlineShop.services.OrderServices;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderServices orderServices;

    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @GetMapping("/")
    public List<Order> find() {
        return orderServices.findAll();
    }

    @DeleteMapping("/id")
    void delete(@PathVariable("id") @NotNull Long id) {
        orderServices.delete(id);
    }
    @PostMapping
    public ResponseEntity<Long> User(@RequestBody Order order) {
        try{
            return new ResponseEntity<>(orderServices.create (order), HttpStatus.CREATED);
        }catch (DataIntegrityViolationException data) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, data.getMessage ());
        }catch (ResponseStatusException exception) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage ());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Long> User(@PathVariable("id") Long id, @Valid @RequestBody Order order) {
        try{
            return new ResponseEntity<>(orderServices.updateById (id, order), HttpStatus.OK);
        }catch (DataIntegrityViolationException data) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST, data.getMessage ());
        }catch (NoSuchElementException elementException){
            throw new ResponseStatusException (HttpStatus.NOT_FOUND, elementException.getMessage ());
        }
        catch (ResponseStatusException exception) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage ());
        }
    }
}


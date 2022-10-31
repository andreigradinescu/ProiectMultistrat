package com.onlineshop.multistrat.chelariu.controllers;

import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.services.UserServices;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    /**
     *
     * @return All entities
     * status Ok 200
     * if is something on the server 500 Internal Server Error
     */
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        try{
            return new ResponseEntity<> (userServices.findAll (), HttpStatus.OK);
        } catch (Throwable throwable){
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage ());
        }
    }

    /**
     *
     * @param id
     * @return urser by id with status Ok 200
     * if is something on the server 500 Internal Server Error
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> find(@PathVariable("id") @NotNull Long id){
        try{
            return new ResponseEntity<> (userServices.find (id), HttpStatus.OK);
        }
        catch (Throwable throwable){
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage ());
        }
    }

    /**
     *
     * @param user
     * @return User id if everything works fine
     * with status 201 Created
     * else 403 Bad Request for invalid data
     * if is something on the server 500 Internal Server Error
     */
    @PostMapping
    public ResponseEntity<Long> User(@RequestBody User user) {
        try{
            return new ResponseEntity<> (userServices.create (user),HttpStatus.CREATED);
        }catch (DataIntegrityViolationException data) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST, data.getMessage ());
        }catch (ResponseStatusException exception) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage ());
        }
    }

    /**
     *
     * @param id Find user by id
     * @param user Update user fields by id
     * @return id user and 200 Ok status if everything woks fine.
     * If data is not valid return 403 Bad Request
     * If user doesn't exist return 404
     * if is something on the server 500 Internal Server Error
     */
    @PutMapping("/{id}")
    public ResponseEntity<Long> User(@PathVariable("id") Long id, @Valid @RequestBody User user) {
        try{
           return new ResponseEntity<>(userServices.updateById (id, user), HttpStatus.OK);
        }catch (DataIntegrityViolationException data) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST, data.getMessage ());
        }catch (NoSuchElementException elementException){
            throw new ResponseStatusException (HttpStatus.NOT_FOUND, elementException.getMessage ());
        }
        catch (ResponseStatusException exception) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage ());
        }
    }

    /**
     *
     * @param id
     * @return ID from frontend and return 200 status ok,
     * If everything works fine.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") @NotNull Long id) {
        try {
            userServices.delete (id);
            return new ResponseEntity<> (HttpStatus.OK);
        } catch (InvalidDataAccessApiUsageException invalidData) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST, invalidData.getMessage ());
        } catch (Throwable throwable) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,throwable.getMessage ());
        }
    }
}

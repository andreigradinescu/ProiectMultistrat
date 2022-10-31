package com.onlineshop.multistrat.controllers;

import com.onlineshop.multistrat.entities.Article;
import com.onlineshop.multistrat.services.ArticleServices;
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
public class ArticleController {

    private final ArticleServices articleServices;

    public ArticleController(ArticleServices articleServices) {
        this.articleServices = articleServices;
    }

    @GetMapping
    public ResponseEntity<List<Article>> findAll(){
        try{
            return new ResponseEntity<> (articleServices.findAll (), HttpStatus.OK);
        } catch (Throwable throwable){
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Article>> find(@PathVariable("id") @NotNull Long id){
        try{
            return new ResponseEntity<> (articleServices.find (id), HttpStatus.OK);
        }
        catch (Throwable throwable){
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage ());
        }
    }

    @PostMapping
    public ResponseEntity<Long> Article(@RequestBody Article article) {
        try{
            return new ResponseEntity<> (articleServices.create (article),HttpStatus.CREATED);
        }catch (DataIntegrityViolationException data) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST, data.getMessage());
        }catch (ResponseStatusException exception) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage ());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> Article(@PathVariable("id") Long id, @Valid @RequestBody Article article) {
        try{
            return new ResponseEntity<>(articleServices.updateById (id, article), HttpStatus.OK);
        }catch (DataIntegrityViolationException data) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST, data.getMessage ());
        }catch (NoSuchElementException elementException){
            throw new ResponseStatusException (HttpStatus.NOT_FOUND, elementException.getMessage ());
        }
        catch (ResponseStatusException exception) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage ());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") @NotNull Long id) {
        try {
            articleServices.delete (id);
            return new ResponseEntity<> (HttpStatus.OK);
        } catch (InvalidDataAccessApiUsageException invalidData) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST, invalidData.getMessage ());
        } catch (Throwable throwable) {
            throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR,throwable.getMessage ());
        }
    }






}

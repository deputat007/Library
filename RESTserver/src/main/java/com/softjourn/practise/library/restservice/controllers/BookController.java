package com.softjourn.practise.library.restservice.controllers;


import com.softjourn.practise.library.entities.Book;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;
import com.softjourn.practise.library.restservice.services.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    private BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> getBook(@PathVariable int id) {
        try {
            return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.add(book);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        try {
            bookService.update(book);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        try {
            bookService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/name/{name}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return new ResponseEntity<>(bookService.getByName(name), HttpStatus.OK);
    }
}

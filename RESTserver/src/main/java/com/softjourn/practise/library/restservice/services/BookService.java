package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Book;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface BookService {

    Book getBook(int id) throws EntityNotFoundException;

    List<Book> getBooks();

    void addBook(Book book);

    void updateBook(Book book) throws EntityNotFoundException;

    void deleteBook(int id) throws EntityNotFoundException;

    List<Book> getByName(String name);
}

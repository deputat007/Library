package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Book;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface BookService extends CrudOperation<Book>{

    List<Book> getByName(String name);
}

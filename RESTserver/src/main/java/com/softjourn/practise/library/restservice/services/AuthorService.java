package com.softjourn.practise.library.restservice.services;


import com.softjourn.practise.library.entities.Author;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;

public interface AuthorService {

    Author getAuthor(int id) throws EntityNotFoundException;

    List<Author> getAuthors();

    void addAuthor(Author author);

    void updateAuthor(Author author) throws EntityNotFoundException;

    void deleteAuthor(int id) throws EntityNotFoundException;

    List<Author> getByFirstName(String firstName);
}

package com.softjourn.practise.library.restservice.services;


import com.softjourn.practise.library.entities.Author;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;

public interface AuthorService extends CrudOperation<Author> {

    List<Author> getByFirstName(String firstName);
}

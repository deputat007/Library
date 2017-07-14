package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Genre;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface GenreService extends CrudOperation<Genre> {

    List<Genre> getByName(String name);
}

package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Genre;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface GenreService {

    Genre getGenre(int id) throws EntityNotFoundException;

    List<Genre> getGenres();

    void addGenre(Genre genre);

    void updateGenre(Genre genre) throws EntityNotFoundException;

    void deleteGenre(int id) throws EntityNotFoundException;

    List<Genre> getByName(String name);
}

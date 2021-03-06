package com.softjourn.practise.library.restservice.services.impl;

import com.softjourn.practise.library.entities.Genre;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;
import com.softjourn.practise.library.restservice.repository.GenreRepository;
import com.softjourn.practise.library.restservice.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre getById(int id) throws EntityNotFoundException {
        Genre genre = genreRepository.findOne(id);

        if (genre == null || genre.getDeleted() != null) {
            throw new EntityNotFoundException(String.format("Genre with id(%d) not found", id));
        }

        return genre;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public void add(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void update(Genre genre) throws EntityNotFoundException {
        if (getById(genre.getId()) != null) {
            genre.setModified(new Date(System.currentTimeMillis()));
            genreRepository.save(genre);
        }
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        Genre existingGenre = getById(id);
        existingGenre.setDeleted(new Date(System.currentTimeMillis()));

        genreRepository.save(existingGenre);
    }

    @Override
    public List<Genre> getByName(String name) {
        name += "%";

        return genreRepository.findByName(name);
    }
}

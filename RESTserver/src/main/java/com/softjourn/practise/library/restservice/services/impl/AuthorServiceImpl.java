package com.softjourn.practise.library.restservice.services.impl;

import com.softjourn.practise.library.entities.Author;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;
import com.softjourn.practise.library.restservice.repository.AuthorRepository;
import com.softjourn.practise.library.restservice.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(int id) throws EntityNotFoundException {
        Author author = authorRepository.findOne(id);

        if (author == null) {
            throw new EntityNotFoundException(String.format("Author with id(%d) not found", id));
        }

        return author;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) throws EntityNotFoundException {
        Author existingAuthor = getAuthor(author.getId());

        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());
        existingAuthor.setBirthday(author.getBirthday());

        authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(Author author) throws EntityNotFoundException {
        Author existingAuthor = getAuthor(author.getId());

        authorRepository.delete(existingAuthor);
    }
}

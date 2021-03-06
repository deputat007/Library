package com.softjourn.practise.library.restservice.services.impl;

import com.softjourn.practise.library.entities.Book;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;
import com.softjourn.practise.library.restservice.repository.BookRepository;
import com.softjourn.practise.library.restservice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(int id) throws EntityNotFoundException {
        Book book = bookRepository.findOne(id);

        if (book == null || book.getDeleted() != null) {
            throw new EntityNotFoundException(String.format("Book with id(%d) not found", id));
        }

        return book;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) throws EntityNotFoundException {
        if (getById(book.getId()) != null) {
            book.setModified(new Date(System.currentTimeMillis()));
            bookRepository.save(book);
        }
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        Book book = getById(id);
        book.setDeleted(new Date(System.currentTimeMillis()));

        bookRepository.save(book);
    }

    @Override
    public List<Book> getByName(String name) {
        name += "%";

        return bookRepository.findByName(name);
    }
}

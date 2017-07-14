package com.softjourn.practise.library.restservice.services;


import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface CrudOperation<T> {

    T getById(int id) throws EntityNotFoundException;

    List<T> getAll();

    void add(T t);

    void update(T t) throws EntityNotFoundException;

    void delete(int id) throws EntityNotFoundException;
}

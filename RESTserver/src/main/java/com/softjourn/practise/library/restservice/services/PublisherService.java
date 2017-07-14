package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Publisher;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface PublisherService extends CrudOperation<Publisher> {

    List<Publisher> getByName(String name);
}

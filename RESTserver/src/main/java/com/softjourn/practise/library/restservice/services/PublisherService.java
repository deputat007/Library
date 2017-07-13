package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Publisher;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface PublisherService {

    Publisher getPublisher(int id) throws EntityNotFoundException;

    List<Publisher> getPublishers();

    void addPublisher(Publisher publisher);

    void updatePublisher(Publisher publisher) throws EntityNotFoundException;

    void deletePublisher(int id) throws EntityNotFoundException;

    List<Publisher> getByName(String name);
}

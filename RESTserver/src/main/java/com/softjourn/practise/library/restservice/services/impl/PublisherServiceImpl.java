package com.softjourn.practise.library.restservice.services.impl;


import com.softjourn.practise.library.entities.Publisher;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;
import com.softjourn.practise.library.restservice.repository.PublisherRepository;
import com.softjourn.practise.library.restservice.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher getById(int id) throws EntityNotFoundException {
        Publisher publisher = publisherRepository.findOne(id);

        if (publisher == null || publisher.getDeleted() != null) {
            throw new EntityNotFoundException(String.format("Publisher with id(%d) not found", id));
        }

        return publisher;
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.getAll();
    }

    @Override
    public void add(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void update(Publisher publisher) throws EntityNotFoundException {
        if (getById(publisher.getId()) != null) {
            publisher.setModified(new Date(System.currentTimeMillis()));

            publisherRepository.save(publisher);
        }
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        Publisher publisher = getById(id);
        publisher.setDeleted(new Date(System.currentTimeMillis()));

        publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getByName(String name) {
        name += "%";

        return publisherRepository.findByName(name);
    }
}

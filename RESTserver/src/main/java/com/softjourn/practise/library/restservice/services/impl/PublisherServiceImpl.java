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
    public Publisher getPublisher(int id) throws EntityNotFoundException {
        Publisher publisher = publisherRepository.findOne(id);

        if (publisher == null || publisher.getDeleted() != null) {
            throw new EntityNotFoundException(String.format("Publisher with id(%d) not found", id));
        }

        return publisher;
    }

    @Override
    public List<Publisher> getPublishers() {
        return publisherRepository.getAll();
    }

    @Override
    public void addPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) throws EntityNotFoundException {
        if (getPublisher(publisher.getId()) != null) {
            publisher.setModified(new Date(System.currentTimeMillis()));

            publisherRepository.save(publisher);
        }
    }

    @Override
    public void deletePublisher(int id) throws EntityNotFoundException {
        Publisher publisher = getPublisher(id);
        publisher.setDeleted(new Date(System.currentTimeMillis()));

        publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getByName(String name) {
        name += "%";

        return publisherRepository.findByName(name);
    }
}

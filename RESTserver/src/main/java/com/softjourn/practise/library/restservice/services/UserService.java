package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.User;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;


public interface UserService extends CrudOperation<User> {

    User findByName(String name);

    User getByName(String name);

    User findByCredential(String userName, String password) throws EntityNotFoundException;
}

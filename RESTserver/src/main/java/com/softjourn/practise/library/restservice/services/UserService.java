package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.User;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface UserService {

    User getUser(int id) throws EntityNotFoundException;

    List<User> getUsers();

    void addUser(User user);

    void updateUser(User user) throws EntityNotFoundException;

    void deleteUser(int id) throws EntityNotFoundException;

    User getByName(String name);

    User findByCredential(String userName, String password) throws EntityNotFoundException;
}

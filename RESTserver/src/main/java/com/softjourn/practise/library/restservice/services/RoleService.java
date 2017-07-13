package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Role;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;

import java.util.List;


public interface RoleService {

    Role getRole(int id) throws EntityNotFoundException;

    List<Role> getRoles();

    void addRole(Role role);

    void updateRole(Role role) throws EntityNotFoundException;

    void deleteRole(int id) throws EntityNotFoundException;

    List<Role> getByName(String name);
}

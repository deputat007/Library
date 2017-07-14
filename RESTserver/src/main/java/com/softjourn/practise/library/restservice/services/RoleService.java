package com.softjourn.practise.library.restservice.services;

import com.softjourn.practise.library.entities.Role;

import java.util.List;


public interface RoleService extends CrudOperation<Role> {

    List<Role> getByName(String name);
}

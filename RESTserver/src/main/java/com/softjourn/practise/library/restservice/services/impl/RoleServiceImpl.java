package com.softjourn.practise.library.restservice.services.impl;


import com.softjourn.practise.library.entities.Role;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;
import com.softjourn.practise.library.restservice.repository.RoleRepository;
import com.softjourn.practise.library.restservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getById(int id) throws EntityNotFoundException {
        Role role = roleRepository.findOne(id);

        if (role == null || role.getDeleted() != null) {
            throw new EntityNotFoundException(String.format("Role with id(%d) not found", id));
        }

        return role;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.getAll();
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void update(Role role) throws EntityNotFoundException {
        if (getById(role.getId()) != null) {
            role.setModified(new Date(System.currentTimeMillis()));

            roleRepository.save(role);
        }
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        Role existingRole = getById(id);

        existingRole.setDeleted(new Date(System.currentTimeMillis()));

        roleRepository.save(existingRole);
    }

    @Override
    public List<Role> getByName(String name) {
        name += "%";

        return roleRepository.findByName(name);
    }
}

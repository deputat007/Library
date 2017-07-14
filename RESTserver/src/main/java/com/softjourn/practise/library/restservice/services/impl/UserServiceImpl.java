package com.softjourn.practise.library.restservice.services.impl;


import com.softjourn.practise.library.entities.User;
import com.softjourn.practise.library.restservice.exceptions.EntityNotFoundException;
import com.softjourn.practise.library.restservice.repository.UserRepository;
import com.softjourn.practise.library.restservice.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.sql.Date;
import java.util.List;

import static org.apache.commons.codec.binary.StringUtils.getBytesUtf8;

@Service
public class UserServiceImpl implements UserService {

    @Value("${security.messageDigestAlgorithm}")
    private String messageDigestAlgorithm;

    private final UserRepository userRepository;
    private final HexBinaryAdapter hexBinaryAdapter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, HexBinaryAdapter hexBinaryAdapter) {
        this.userRepository = userRepository;
        this.hexBinaryAdapter = hexBinaryAdapter;
    }

    @Override
    public User getById(int id) throws EntityNotFoundException {
        User user = userRepository.findOne(id);

        if (user == null || user.getDeleted() != null) {
            throw new EntityNotFoundException(String.format("User with id(%d) not found", id));
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void add(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) throws EntityNotFoundException {
        if (getById(user.getId()) != null) {
            user.setModified(new Date(System.currentTimeMillis()));

            userRepository.save(user);
        }
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        User existingUser = getById(id);

        existingUser.setDeleted(new Date(System.currentTimeMillis()));

        userRepository.save(existingUser);
    }

    @Override
    public User findByName(String name) {
        name += "%";

        return userRepository.findByName(name);
    }

    @Override
    public User getByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public User findByCredential(String userName, String password) throws EntityNotFoundException {
        User user = userRepository.findByCredential(userName, password);

        if (user == null) {
            throw new EntityNotFoundException("Invalid login or password");
        }

        return user;
    }

    public String encodePassword(String password) {
        return hexBinaryAdapter.marshal(DigestUtils.getDigest(messageDigestAlgorithm).digest(getBytesUtf8(password)));
    }
}

package com.softjourn.practise.library.restservice.controllers;


import com.softjourn.practise.library.entities.User;
import com.softjourn.practise.library.restservice.services.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    private UserServiceImpl userService;

    @Autowired
    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if (user == null || user.getRole() == null || StringUtils.isBlank(user.getUserName()) ||
                StringUtils.isBlank(user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User alreadyRegisteredUser = userService.getByName(user.getUserName());
        if (alreadyRegisteredUser != null) {
            return new ResponseEntity<>(String.format("User %s already exist!", user.getUserName()),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }

        userService.addUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

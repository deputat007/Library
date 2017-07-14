package com.softjourn.practise.library.restservice.controllers;


import com.softjourn.practise.library.entities.User;
import com.softjourn.practise.library.restservice.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> getUser(@RequestParam String login, @RequestParam String password) {
        try {
            User user = userService.findByName(login);
            if (user == null) {
                throw new BadCredentialsException("Invalid login");
            }
            if (!user.getPassword().equals(userService.encodePassword(password))) {
                throw new BadCredentialsException("Wrong password");
            }
            return new ResponseEntity<>(userService.findByName(login), HttpStatus.OK);
        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}

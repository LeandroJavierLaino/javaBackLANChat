package com.users;

import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/users")
    public String newUser(@RequestBody User user) {
        List<User> userFind = repository.findByUsername(user.getUsername());

        if (userFind.isEmpty())
            repository.save(user);

        return user.getUsername();
    }

    @GetMapping("/users")
    public String getUsers() throws JsonProcessingException {
        List<User> users = repository.findAll();

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(users);
        } catch (JsonGenerationException e) {
            throw e;
        }
    }
}

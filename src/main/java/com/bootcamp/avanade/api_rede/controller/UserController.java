package com.bootcamp.avanade.api_rede.controller;

import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) {
        var userCreated = service.create(userToCreate);

        return ResponseEntity.ok().body(userCreated);
    }
}

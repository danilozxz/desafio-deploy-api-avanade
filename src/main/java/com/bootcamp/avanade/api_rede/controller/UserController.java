package com.bootcamp.avanade.api_rede.controller;

import com.bootcamp.avanade.api_rede.controller.openAPI.UserControllerOpenAPI;
import com.bootcamp.avanade.api_rede.dto.user.UserCreateDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserUpdateDTO;
import com.bootcamp.avanade.api_rede.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController implements UserControllerOpenAPI {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        var user = service.findById(id);
        var response = UserResponseDTO.from(user);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        var listUsers = service.findAll();
        return ResponseEntity.ok().body(listUsers);
    }

    @PostMapping("")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userToCreate) {
        var userCreated = service.create(userToCreate);
        var response = UserResponseDTO.from(userCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO, @PathVariable Long id) {
        var userUpdated = service.update(userUpdateDTO, id);

        return ResponseEntity.ok().body(userUpdated);
    }
}

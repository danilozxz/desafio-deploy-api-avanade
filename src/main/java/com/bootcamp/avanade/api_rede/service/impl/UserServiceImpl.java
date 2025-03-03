package com.bootcamp.avanade.api_rede.service.impl;

import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.repository.UserRepository;
import com.bootcamp.avanade.api_rede.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {

        return repository.save(userToCreate);
    }

}

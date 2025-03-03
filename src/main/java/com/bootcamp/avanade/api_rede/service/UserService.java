package com.bootcamp.avanade.api_rede.service;

import com.bootcamp.avanade.api_rede.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}

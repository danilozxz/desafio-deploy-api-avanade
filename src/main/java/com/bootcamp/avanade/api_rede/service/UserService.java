package com.bootcamp.avanade.api_rede.service;

import java.util.List;

import com.bootcamp.avanade.api_rede.dto.user.UserCreateDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserUpdateDTO;
import com.bootcamp.avanade.api_rede.model.User;

public interface UserService {

    User findById(Long id);

    List<UserResponseDTO> findAll();

    void delete(Long id);

    UserResponseDTO update(UserUpdateDTO userToUpdate, Long id);
}

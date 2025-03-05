package com.bootcamp.avanade.api_rede.service.impl;

import com.bootcamp.avanade.api_rede.dto.user.UserCreateDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserUpdateDTO;
import com.bootcamp.avanade.api_rede.mapper.UserMapper;
import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.repository.UserRepository;
import com.bootcamp.avanade.api_rede.service.UserService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return repository.findAll().stream().map(userMapper::toUserResponseDTO).toList();
    }

    @Override
    public User create(UserCreateDTO userToCreate) {
        User user = userMapper.map(userToCreate);
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuário com o ID especificado não encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public UserResponseDTO update(UserUpdateDTO userToUpdate, Long id) {

        User user = repository.findById(id).orElseThrow(NoSuchElementException::new);

        userMapper.updateUser(userToUpdate, user);

        return userMapper.toUserResponseDTO(repository.save(user));
    }
}

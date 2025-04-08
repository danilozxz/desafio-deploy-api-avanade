package com.bootcamp.avanade.api_rede.service.impl;

import com.bootcamp.avanade.api_rede.dto.user.UserCreateDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserUpdateDTO;
import com.bootcamp.avanade.api_rede.exceptions.user.UserNotFoundException;
import com.bootcamp.avanade.api_rede.exceptions.user.UsernameNullException;
import com.bootcamp.avanade.api_rede.mapper.UserMapper;
import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.repository.UserRepository;
import com.bootcamp.avanade.api_rede.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return findUserById(id);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return repository.findAll().stream().map(userMapper::toUserResponseDTO).toList();
    }

    @Override
    public void delete(Long id) {

        findUserById(id);

        repository.deleteById(id);
    }

    @Override
    public UserResponseDTO update(UserUpdateDTO userToUpdate, Long id) {

        validateUsername(userToUpdate.username());

        User user = findUserById(id);

        userMapper.updateUser(userToUpdate, user);

        return userMapper.toUserResponseDTO(repository.save(user));
    }

    public void validateUsername(String username) {
        if(username == null || username.isEmpty()) {
            throw new UsernameNullException();
        }
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}

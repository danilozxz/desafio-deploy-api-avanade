package com.bootcamp.avanade.api_rede.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User map(UserResponseDTO userResponseDTO);
}

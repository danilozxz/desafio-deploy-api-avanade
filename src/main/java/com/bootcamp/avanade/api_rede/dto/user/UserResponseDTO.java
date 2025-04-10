package com.bootcamp.avanade.api_rede.dto.user;

import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.model.UserRole;

import java.time.LocalDateTime;

public record UserResponseDTO(Long id, String username, String email, LocalDateTime createdAt, UserRole role) {
    public static UserResponseDTO from(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getCreatedAt(),
            user.getRole()
        );
    }
}

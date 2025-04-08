package com.bootcamp.avanade.api_rede.dto.auth;

import com.bootcamp.avanade.api_rede.model.UserRole;

public record RegisterDTO(String username, String email, String password, UserRole role) {}

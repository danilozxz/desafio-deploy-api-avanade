package com.bootcamp.avanade.api_rede.controller.openAPI;

import com.bootcamp.avanade.api_rede.dto.auth.AuthenticationDTO;
import com.bootcamp.avanade.api_rede.dto.auth.RegisterDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Authentication")
public interface AuthenticationControllerOpenAPI {

    @Operation(summary = "Fazer login")
    ResponseEntity login(AuthenticationDTO dto);

    @Operation(summary = "Cadastrar novo usuário")
    ResponseEntity<UserResponseDTO> register(RegisterDTO dto);
}

package com.bootcamp.avanade.api_rede.controller.openAPI;

import com.bootcamp.avanade.api_rede.dto.user.UserCreateDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "User")
public interface UserControllerOpenAPI {

    @Operation(summary = "Buscar usuário pelo ID")
    ResponseEntity<UserResponseDTO> findById(Long id);

    @Operation(summary = "Listar todos usuários")
    ResponseEntity<List<UserResponseDTO>> findAll();

    @Operation(summary = "Criar novo usuário")
    ResponseEntity<UserResponseDTO> createUser(UserCreateDTO userToCreate);

    @Operation(summary = "Deletar usuário pelo ID")
    ResponseEntity<Void> deleteById(Long id);

    @Operation(summary = "Atualizar usuário")
    ResponseEntity<UserResponseDTO> updateUser(UserUpdateDTO userUpdateDTO, Long id);


}

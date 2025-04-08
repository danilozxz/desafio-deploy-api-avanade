package com.bootcamp.avanade.api_rede.controller.auth;

import com.bootcamp.avanade.api_rede.controller.openAPI.AuthenticationControllerOpenAPI;
import com.bootcamp.avanade.api_rede.dto.auth.AuthenticationDTO;
import com.bootcamp.avanade.api_rede.dto.auth.RegisterDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthenticationControllerOpenAPI {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dto) {
        return authenticationService.login(dto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid RegisterDTO dto){
        return authenticationService.register(dto);
    }
}

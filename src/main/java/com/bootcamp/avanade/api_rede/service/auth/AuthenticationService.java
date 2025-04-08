package com.bootcamp.avanade.api_rede.service.auth;

import com.bootcamp.avanade.api_rede.dto.auth.AuthenticationDTO;
import com.bootcamp.avanade.api_rede.dto.auth.LoginResponseDTO;
import com.bootcamp.avanade.api_rede.dto.auth.RegisterDTO;
import com.bootcamp.avanade.api_rede.dto.user.UserResponseDTO;
import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository repository;

    public ResponseEntity login(AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    public ResponseEntity<UserResponseDTO> register(RegisterDTO dto){
        if(this.repository.findByUsername(dto.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User newUser = new User(dto.username(), dto.email(), encryptedPassword, dto.role());

        this.repository.save(newUser);

        var response = UserResponseDTO.from(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

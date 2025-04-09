package com.bootcamp.avanade.api_rede.exceptions.user;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(String username) {
        super("O username " + username + " já existe");
    }

}

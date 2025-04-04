package com.bootcamp.avanade.api_rede.exceptions.user;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Usuário com o id " + id +" não encontrado");
    }

}

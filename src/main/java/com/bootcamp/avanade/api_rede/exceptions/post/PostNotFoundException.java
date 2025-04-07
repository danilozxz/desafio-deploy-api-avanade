package com.bootcamp.avanade.api_rede.exceptions.post;

public class PostNotFoundException extends  RuntimeException{

    public PostNotFoundException(Long id) {
        super("Post com o id " + id +" não encontrado");
    }

}

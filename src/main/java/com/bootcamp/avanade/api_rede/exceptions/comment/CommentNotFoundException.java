package com.bootcamp.avanade.api_rede.exceptions.comment;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(Long id) {
        super("Comentário com o id " + id +" não encontrado");
    }
}

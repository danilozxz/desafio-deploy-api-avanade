package com.bootcamp.avanade.api_rede.exceptions.user;

public class EmailExistsException extends RuntimeException {

  public EmailExistsException(String email) {
        super("O email " + email + " já está cadastrado");
  }

}

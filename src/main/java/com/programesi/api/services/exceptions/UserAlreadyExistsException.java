package com.programesi.api.services.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Já existe um User com este e-mail!";

    public UserAlreadyExistsException() {
        super(ERROR_MESSAGE);
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}


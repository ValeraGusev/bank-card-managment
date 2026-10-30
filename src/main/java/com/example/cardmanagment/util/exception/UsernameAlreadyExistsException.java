package com.example.cardmanagment.util.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String username) {
        super("Пользователь с именем " + username + " уже существует");
    }
}

package com.example.demuser.controller;

public class UserNotFounException extends RuntimeException {
    public UserNotFounException(String id) {
        super(String.format("No user found with id: ", id));
    }
}

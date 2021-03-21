package com.example.demuser.controller;

public class AdressNotFounfException extends  RuntimeException{
    public AdressNotFounfException(String s) {
        super("No adress with id: " +s);
    }
}

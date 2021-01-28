package com.example.News_portal.exceptions;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(){
        super("JWT token is expired or invalid");
    }
}

package com.example.News_portal.exceptions;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(){
        super("Element not found.");
    }
}

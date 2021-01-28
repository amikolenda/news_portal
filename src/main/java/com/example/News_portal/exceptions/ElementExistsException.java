package com.example.News_portal.exceptions;

public class ElementExistsException extends RuntimeException {
    public ElementExistsException(){
        super("Can not create element. Element already exists.");
    }

}

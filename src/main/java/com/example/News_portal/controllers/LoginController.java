package com.example.News_portal.controllers;

import com.example.News_portal.security.payload.LoginRequest;
import com.example.News_portal.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;


    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest){
        return loginService.authenticateUser(loginRequest);

    }

}

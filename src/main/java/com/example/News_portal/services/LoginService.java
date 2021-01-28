package com.example.News_portal.services;

import com.example.News_portal.security.payload.JwtAuthenticationResponse;
import com.example.News_portal.security.payload.LoginRequest;
import com.example.News_portal.security.services.AdminDetailsImpl;
import com.example.News_portal.utils.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {
    @Autowired
    JwtUtility jwtUtility;

    @Autowired
    AuthenticationManager authenticationManager;

    public ResponseEntity<?> authenticateUser(@Valid LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateToken(authentication);
        AdminDetailsImpl adminDetails = (AdminDetailsImpl) authentication.getPrincipal();
        List<String> roles = adminDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, adminDetails.getUsername(), roles));
    }

}

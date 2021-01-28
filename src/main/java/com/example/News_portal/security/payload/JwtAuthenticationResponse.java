package com.example.News_portal.security.payload;

import java.util.List;

public class JwtAuthenticationResponse {
    private Long id;
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private List<String> roles;


    public JwtAuthenticationResponse(String accessToken, Long id, String username, List<String> roles) {
        this.id = id;
        this.accessToken = accessToken;
        this.username = username;
        this.roles = roles;
    }


    public JwtAuthenticationResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public JwtAuthenticationResponse setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public JwtAuthenticationResponse setUsername(String username) {
        this.username = username;
        return this;
    }

    public JwtAuthenticationResponse setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public JwtAuthenticationResponse setId(Long id) {
        this.id = id;
        return this;
    }

}

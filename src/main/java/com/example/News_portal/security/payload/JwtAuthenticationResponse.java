package com.example.News_portal.security.payload;

import java.util.List;

public class JwtAuthenticationResponse {
    private Long id;
    private String accessToken;
    private String tokenType = "Bearer";
    private String user_name;
    private List<String> roles;


    public JwtAuthenticationResponse(String accessToken, Long id, String user_name, List<String> roles) {
        this.id = id;
        this.accessToken = accessToken;
        this.user_name = user_name;
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

    public JwtAuthenticationResponse setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getUser_name() {
        return user_name;
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

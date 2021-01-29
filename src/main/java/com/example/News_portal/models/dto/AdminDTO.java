package com.example.News_portal.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.Objects;

public class AdminDTO {

    private Long id;
    @NotNull
    @JsonProperty("user_name")
    private String userName;
    @NotNull
    private String password;
    private String role = "ADMIN";

    public AdminDTO() {
    }
    public AdminDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public AdminDTO(Long id,String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    public AdminDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AdminDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public AdminDTO setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO admin = (AdminDTO) o;
        return Objects.equals(userName, admin.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    public Long getId() {
        return id;
    }

    public AdminDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}

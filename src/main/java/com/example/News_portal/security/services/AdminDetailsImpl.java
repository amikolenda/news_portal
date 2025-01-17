package com.example.News_portal.security.services;

import com.example.News_portal.models.Admin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AdminDetailsImpl implements UserDetails {

    @JsonIgnore
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Long id;
    private String user_name;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public AdminDetailsImpl() {
    }

    public AdminDetailsImpl(Long id, String user_name, String password,
                            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.user_name = user_name;
        this.password = passwordEncoder.encode(password);
        this.authorities = authorities;
    }



    public static AdminDetailsImpl build(Admin admin) {
        List<GrantedAuthority> authorities = Arrays.stream(admin.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new AdminDetailsImpl(
                admin.getId(),
                admin.getUserName(),
                admin.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDetailsImpl that = (AdminDetailsImpl) o;
        return user_name.equals(that.user_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_name);
    }


}

package com.example.News_portal.security.services;

import com.example.News_portal.models.Admin;
import com.example.News_portal.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Admin> admin = Optional.ofNullable(adminRepository.findAdminByUserName(userName));
        if (admin.isPresent()) return AdminDetailsImpl.build(admin.get());

        throw new UsernameNotFoundException("User Not Found: " + userName);
    }
}

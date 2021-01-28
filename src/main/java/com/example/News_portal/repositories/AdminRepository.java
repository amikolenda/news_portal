package com.example.News_portal.repositories;

import com.example.News_portal.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findAdminByUserName(String userName);
}

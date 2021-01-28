package com.example.News_portal.services;

import com.example.News_portal.repositories.AdminRepository;
import com.example.News_portal.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private DTOConverterService dtoConverterService;

    @Autowired
    private AdminRepository adminRepository;




}

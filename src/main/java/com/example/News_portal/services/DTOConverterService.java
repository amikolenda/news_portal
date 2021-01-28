package com.example.News_portal.services;

import com.example.News_portal.models.Admin;
import com.example.News_portal.models.News;
import com.example.News_portal.models.dto.AdminDTO;
import com.example.News_portal.models.dto.NewsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOConverterService {

    @Autowired
    private ModelMapper modelMapper;

    public NewsDTO convertNewsDAOToDTO(News news){
        NewsDTO newsDTO = modelMapper.map(news, NewsDTO.class);
        return newsDTO;
    }
    public News convertNewsDTOToDAO(NewsDTO newsDTO){
        News news = modelMapper.map(newsDTO, News.class);
        return news;
    }

    public AdminDTO convertAdminDAOToDTO(Admin admin){
        AdminDTO adminDTO = modelMapper.map(admin, AdminDTO.class);
        return adminDTO;
    }
    public Admin convertAdminDTOToDAO(AdminDTO adminDTO){
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        return admin;
    }



}
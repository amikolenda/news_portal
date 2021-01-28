package com.example.News_portal.services;

import com.example.News_portal.exceptions.ElementExistsException;
import com.example.News_portal.models.News;
import com.example.News_portal.models.dto.NewsDTO;
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
    private AdminService adminService;

    public NewsDTO save(NewsDTO newsDTO) throws ElementExistsException {
        if (newsRepository.existsByTitle(newsDTO.getTitle())) {
            throw new ElementExistsException();
        }
        News news = dtoConverterService.convertNewsDTOToDAO(newsDTO);
        news.setAuthor(adminService.findByUserName(news.getAuthor().getUserName()));
        News save = newsRepository.save(news);
        return dtoConverterService.convertNewsDAOToDTO(save);
    }


}

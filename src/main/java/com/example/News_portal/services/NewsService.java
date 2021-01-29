package com.example.News_portal.services;

import com.example.News_portal.exceptions.ElementExistsException;
import com.example.News_portal.exceptions.ElementNotFoundException;
import com.example.News_portal.models.News;
import com.example.News_portal.models.dto.NewsDTO;
import com.example.News_portal.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private DTOConverterService dtoConverterService;

    @Autowired
    private AdminService adminService;

    public NewsDTO saveDTO(NewsDTO newsDTO) throws ElementExistsException {
        if (newsRepository.existsByTitle(newsDTO.getTitle())) {
            throw new ElementExistsException();
        }
        News news = dtoConverterService.convertNewsDTOToDAO(newsDTO);
        news.setAuthor(adminService.findByUserName(news.getAuthor().getUserName()));
        News save = newsRepository.save(news);
        return dtoConverterService.convertNewsDAOToDTO(save);
    }

    public News save(News news) throws ElementNotFoundException {
        if (newsRepository.existsByTitle(news.getTitle())) {
            News existingNews = newsRepository.findByTitle(news.getTitle());
            news.setId(existingNews.getId());
        }
        String authorUserName = news.getAuthor().getUserName();
        news.setAuthor(adminService.findByUserName(authorUserName));
        News save = newsRepository.save(news);
        return save;
    }


    public List<NewsDTO> findAllDTO() throws ElementNotFoundException {
        List<News> allNews = newsRepository.findAll();
        List<NewsDTO> allNewsList = allNews.stream().map(dtoConverterService::convertNewsDAOToDTO).collect(Collectors.toList());
        return allNewsList;
    }

    public News findById(Long id) throws ElementNotFoundException {
        try{
            News found = newsRepository.findById(id).get();
            return found;
        } catch (Exception e){
            throw new ElementNotFoundException();
        }
    }

    public NewsDTO findDTOById(Long id) throws ElementNotFoundException{
        News found = findById(id);
        return dtoConverterService.convertNewsDAOToDTO(found);

    }

    public List<NewsDTO> findAllDTOByAuthor(String userName) throws ElementNotFoundException{
        List<News> allNews = newsRepository.findAllByAuthorOrderByDateTimeCreated(adminService.findByUserName(userName));
        List<NewsDTO> allNewsList = allNews.stream().map(dtoConverterService::convertNewsDAOToDTO).collect(Collectors.toList());
        return allNewsList;
    }

    public NewsDTO updateDTO(NewsDTO newsDTO) {
        if (!newsRepository.existsByTitle(newsDTO.getTitle())) {
            throw new ElementNotFoundException();
        }
        News newNews = dtoConverterService.convertNewsDTOToDAO(newsDTO);
        newNews.setAuthor(adminService.findByUserName(newNews.getAuthor().getUserName()));

        newsRepository.save(newNews);
        return dtoConverterService.convertNewsDAOToDTO(newNews);

    }

    public void delete(Long id) throws ElementNotFoundException{
        News news = findById(id);
        newsRepository.delete(news);
    }

    public void saveAll(List<News> news) {
        for (News newS:news) save(newS);
    }

    public NewsDTO findDTOByTitle(String title) {
        try{
            News found = newsRepository.findByTitle(title);
            return dtoConverterService.convertNewsDAOToDTO(found);
        } catch (Exception e){
            throw new ElementNotFoundException();
        }
    }
}

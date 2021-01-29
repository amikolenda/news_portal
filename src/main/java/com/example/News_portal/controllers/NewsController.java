package com.example.News_portal.controllers;

import com.example.News_portal.exceptions.ElementNotFoundException;
import com.example.News_portal.models.dto.NewsDTO;
import com.example.News_portal.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<NewsDTO>> showNews() throws ElementNotFoundException {
        return ResponseEntity.ok().body(newsService.findAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> showNewsById(@PathVariable("id") Long id) throws ElementNotFoundException {
        return ResponseEntity.ok().body(newsService.findDTOById(id));
    }

    @GetMapping("/{title}")
    public ResponseEntity<NewsDTO> showNewsByTitle(@PathVariable("title") String title) throws ElementNotFoundException {
        return ResponseEntity.ok().body(newsService.findDTOByTitle(title));
    }


}

package com.example.News_portal.controllers;

import com.example.News_portal.exceptions.ElementExistsException;
import com.example.News_portal.exceptions.ElementNotFoundException;
import com.example.News_portal.models.dto.NewsDTO;
import com.example.News_portal.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/news/admin")
public class AdminNewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<NewsDTO>> showAllNewsByAuthor(Long id) throws ElementNotFoundException {
        return ResponseEntity.ok().body(newsService.findAllDTOByAuthor(id));
    }

    @PostMapping("/create")
    public ResponseEntity<NewsDTO> createNews(@RequestBody @Valid NewsDTO newsDTO) throws ElementExistsException, ElementNotFoundException {
        return ResponseEntity.ok().body(newsService.saveDTO(newsDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> updateNews(@PathVariable("id") Long id,@RequestBody @Valid NewsDTO newsDTO) throws ElementExistsException, ElementNotFoundException {
        return ResponseEntity.ok().body(newsService.updateDTO(newsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable("id") Long id) throws ElementNotFoundException {
        newsService.delete(id);
        return ResponseEntity.ok().body("News with an id: " + id + "is deleted");
    }




}

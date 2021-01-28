package com.example.News_portal.repositories;

import com.example.News_portal.models.Admin;
import com.example.News_portal.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    public List<News> findAllByAuthorOrderByDateTimeCreated(Admin author);

    public boolean existsByTitle(String title);

    public News findByTitle(String title);
}

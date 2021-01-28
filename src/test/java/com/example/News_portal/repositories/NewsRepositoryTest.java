package com.example.News_portal.repositories;

import com.example.News_portal.models.Admin;
import com.example.News_portal.models.News;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class NewsRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    AdminRepository adminRepository;


    @Test
    void findAllByAuthorOrderByDateTimeCreated_newsExist_returnsList() {
        Admin author = adminRepository.findAdminByUserName("admin");
        News news = new News("A Title", "A description",author);
        entityManager.persist(news);
        entityManager.flush();

        List<News> found = newsRepository.findAllByAuthorOrderByDateTimeCreated(author);

        assertThat(found)
                .isNotNull();
        assertThat(found.get(0).getAuthor())
                .isEqualTo(author);
    }
}
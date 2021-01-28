package com.example.News_portal.repositories;

import com.example.News_portal.models.Admin;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class AdminRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void findAdminByUserName_adminExists_returnAdmin() {
        Admin admin = new Admin("alex", "password");
        entityManager.persist(admin);
        entityManager.flush();

        Admin found = adminRepository.findAdminByUserName(admin.getUserName());

        assertThat(found.getUserName())
                .isEqualTo(admin.getUserName());
    }

    @Test
    void findAdminByUserName_adminDoesntExist_returnNull() {
        Admin admin = new Admin("alex2", "password");

        Admin found = adminRepository.findAdminByUserName(admin.getUserName());

        assertThat(found)
                .isEqualTo(null);
    }

}
package com.example.News_portal.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Table(name = "ADMIN")
@Entity
public class Admin implements Serializable {
    private static final long serialVersionUID = 4241824572545764721L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "user_name")
    @NotNull
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role = "ADMIN";
    @Column(name = "news")
    @OneToMany(mappedBy="author")
    private Set<News> news;

    public Admin() {
    }
    public Admin(@NotNull String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public Admin setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Admin setRole(String role) {
        this.role = role;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Admin setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(userName, admin.userName);
    }

    public Set<News> getNews() {
        return news;
    }

    public Admin setNews(Set<News> news) {
        this.news = news;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

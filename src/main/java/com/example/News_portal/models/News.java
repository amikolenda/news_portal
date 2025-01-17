package com.example.News_portal.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(name = "NEWS")
@Entity
public class News implements Serializable {
    private static final long serialVersionUID = 5874705216070200136L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "text")
    @NotNull
    private String text;
    @JsonProperty("date_time_created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateTimeCreated;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "user_name")
    private Admin author;
    @Column(name = "img")
    private String img;

    public News() {
    }

    public News(@NotNull String title, @NotNull String text, Date dateTimeCreated, @NotNull Admin author, String img) {
        this.title = title;
        this.text = text;
        this.dateTimeCreated = dateTimeCreated;
        this.author = author;
        this.img = img;
    }

    public News(@NotNull String title, @NotNull String text, @NotNull Admin author) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.dateTimeCreated = new Date();
    }

    public News(@NotNull String title, @NotNull String text, Date dateTimeCreated, @NotNull Admin author) {
        this.title = title;
        this.text = text;
        this.dateTimeCreated = dateTimeCreated;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public News setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public News setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public News setText(String text) {
        this.text = text;
        return this;
    }
    @JsonProperty("date_time_created")
    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public News setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
        return this;
    }

    public Admin getAuthor() {
        return author;
    }

    public News setAuthor(Admin author) {
        this.author = author;
        return this;
    }

    public String getImg() {
        return img;
    }

    public News setImg(String img) {
        this.img = img;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id.equals(news.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

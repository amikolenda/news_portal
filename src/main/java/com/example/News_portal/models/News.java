package com.example.News_portal.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(name = "NEWS")
@Entity
public class News implements Serializable {
    private static final long serialVersionUID = 5874705216070200136L;

    @Id
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
    @Column(name = "author")
    @NotNull
    private Admin author;

    public News() {
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

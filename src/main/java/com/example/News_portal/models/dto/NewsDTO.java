package com.example.News_portal.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class NewsDTO {
    @JsonProperty("title")
    @NotNull
    private String title;
    @JsonProperty("text")
    @NotNull
    private String text;
    @NotNull
    @JsonProperty("date_time_created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateTimeCreated;
    @JsonProperty("author")
    @NotNull
    private AdminDTO author;
    private String img;

    public NewsDTO() {
    }

    public NewsDTO(@NotNull String title, @NotNull String text, @NotNull Date dateTimeCreated, @NotNull AdminDTO author, String img) {
        this.title = title;
        this.text = text;
        this.dateTimeCreated = dateTimeCreated;
        this.author = author;
        this.img = img;
    }

    public NewsDTO(@NotNull String title, @NotNull String text, @NotNull Date dateTimeCreated, @NotNull AdminDTO author) {
        this.title = title;
        this.text = text;
        this.dateTimeCreated = dateTimeCreated;
        this.author = author;
    }

    public NewsDTO(@NotNull String title, @NotNull String text, @NotNull AdminDTO author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public NewsDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public NewsDTO setText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("date_time_created")
    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public NewsDTO setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
        return this;
    }

    public AdminDTO getAuthor() {
        return author;
    }

    public NewsDTO setAuthor(AdminDTO author) {
        this.author = author;
        return this;
    }

    public String getImg() {
        return img;
    }

    public NewsDTO setImg(String img) {
        this.img = img;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDTO newsDTO = (NewsDTO) o;
        return title.equals(newsDTO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

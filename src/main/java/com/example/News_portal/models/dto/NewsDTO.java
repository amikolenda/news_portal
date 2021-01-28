package com.example.News_portal.models.dto;

import com.example.News_portal.models.Admin;
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
    private Admin author;

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

    public Admin getAuthor() {
        return author;
    }

    public NewsDTO setAuthor(Admin author) {
        this.author = author;
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

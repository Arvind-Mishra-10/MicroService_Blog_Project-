package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")

public class Post {
    @Id
    private String id;
    private String title;
    private String description;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

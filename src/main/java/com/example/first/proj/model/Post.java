package com.example.first.proj.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

public class Post {
    private int userId;
    private int id;
    private  String title;
    private String body;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
}

package com.example.fanshopV2.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ls {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    @ManyToOne
    @JoinColumn(name = "ls_user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    Ls () {

    }

    public Ls(String text) {
        this.text = text;
    }

    public Ls(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

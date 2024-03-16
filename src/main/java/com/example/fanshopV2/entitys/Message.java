package com.example.fanshopV2.entitys;

import jakarta.persistence.*;

@Entity(name = "Message")
// This tells Hibernate to make a table out of this class
public class Message {
    public Message() {}
    public Message(String text, String author) {
        this.text = text;
        this.tag = author;
    }
    public Message(String text, String author, User authorUser) {
        this.text = text;
        this.tag = author;
        this.authorUser = authorUser;
        System.out.println(this.authorUser);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User authorUser;
    private String NameAuthor;

    public void addNameAuthor() {
        NameAuthor = authorUser.getUsername();
        System.out.println(NameAuthor);
    }

    public String getNameAuthor() {
        return NameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        NameAuthor = nameAuthor;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String author) {
        this.tag = author;
    }
    public User getAuthorUser() {
        return authorUser;
    }
    public void setAuthorUser(User authorUser) {
        this.authorUser = authorUser;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}

package com.example.fanshopV2.entitys.stripeEntitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String intentID;
    private String clientSecret;

    public Response() {

    }

    public Response(String intentID, String clientSecret) {
        this.intentID = intentID;
        this.clientSecret = clientSecret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntentID() {
        return intentID;
    }

    public void setIntentID(String intentID) {
        this.intentID = intentID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}

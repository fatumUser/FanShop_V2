package com.example.fanshopV2.configs;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${stripe.api.secretKey}")
    private String stripeSecretKey;

    public String getStripeSecretKey() {
        return stripeSecretKey;
    }

    public void setStripeSecretKey(String stripeSecretKey) {
        this.stripeSecretKey = stripeSecretKey;
    }

    @PostConstruct
    private void stripeKeySet() {
        Stripe.apiKey = stripeSecretKey;
        System.out.println(stripeSecretKey + "888");
    }
}

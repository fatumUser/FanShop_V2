package com.example.fanshopV2;

import com.example.fanshopV2.configs.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FantomShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(FantomShopApplication.class, args);
        int a = 10;
        int b = 2;
        try {
            int res = a/b;
            System.out.println(res);
        } catch (ArithmeticException arithmeticException) {
            System.out.println("Еблан на 0 делить нельзя");
        }

        Config config = new Config();
        System.out.println("Stripe key: " + config.getStripeSecretKey());

    }
}

package com.example.fanshopV2.configs;

import com.example.fanshopV2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "controllers, entitys, repositories, services, configs")
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Autowired
    private UserService userService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                 csrf()//Disabled CSRF protection
                .disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers  // ПОСЛЕ ВХОДА В АККАУНТ
                          (              "main",
                                         "basket",
                                         "addMessage",
                                         "filter",
                                         "transaction",
                                         "avatar",
                                         "profile",
                                         "charge",
                                         "card/token",
                                         "NikeAirMaxBlue",
                                         "addBasket1",
                                         "addAvatar",
                                         "FudbolkaVetements",
                                         "BalenciagaKrossovki",
                                  "BurberryFutbolka",
                                  "BurberryKedi",
                                  "DolceGabbanaFutbolka",
                                  "DolceGabbanaSumka",
                                  "DolceGabbanaSwitshot",
                                  "GucciKedi",
                                  "/",
                                  "create-payment-intent",
                                  "/message"

                                )
                        .authenticated()
                        .requestMatchers // СРАЗУ ДОСТУПНЫЕ
                                ("/registration", "/RegistrationAdd", "/css/styles.css", "/css/login.css", "/css/header.css",
                                        "/js/main.js", "checkout.css", "checkout.js", "js/learn.js",
                                        "/img/basket.svg",
                                        "/img/login.svg",
                                          "/img/Nike-SB-Dunk-Green-Blue.jpg",
                                          "/img/Vetemens_Футболка.jpg",
                                          "/img/BALENCIAGA_krossovki_Drive.jpg",
                                          "/img/BURBERRY_futbolka.jpg",
                                          "/img/BURBERRY_KEDI.jpg",
                                          "/img/DOLCE-GABBANA_futbolka.jpg",
                                          "/img/DOLCE-GABBANA_sumka.jpg",
                                          "/img/DOLCE-GABBANA_switshot.jpg",
                                          "/img/GUCCI_kedi_tennis1977.jpg",
                                          "/img/like.png",
                                           "GetInfo",
                                        "TestMethod",
                                        "/loginP",
                                        "charge",
                                        "cardToken"

                        ).permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/main", true)
                )
                .logout(logout -> logout
                        .permitAll());

        return http.build();
    }
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}

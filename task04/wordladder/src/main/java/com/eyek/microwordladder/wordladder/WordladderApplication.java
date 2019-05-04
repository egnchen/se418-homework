package com.eyek.microwordladder.wordladder;

import com.eyek.microwordladder.wordladder.service.AuthenticationService;
import com.eyek.microwordladder.wordladder.service.AuthenticationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WordladderApplication {

    public static final String AUTH_SERVICE_URL = "http://authentication-service";

    public static void main(String[] args) {
        SpringApplication.run(WordladderApplication.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationServiceImpl(AUTH_SERVICE_URL);
    }
}

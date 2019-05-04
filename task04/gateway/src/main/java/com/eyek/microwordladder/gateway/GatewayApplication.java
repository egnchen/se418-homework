package com.eyek.microwordladder.gateway;

import com.eyek.microwordladder.gateway.service.AuthenticationService;
import com.eyek.microwordladder.gateway.service.AuthenticationServiceImpl;
import com.eyek.microwordladder.gateway.service.WordLadderService;
import com.eyek.microwordladder.gateway.service.WordLadderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
public class GatewayApplication {
    public static final String AUTH_SERVICE_URL = "http://authentication-service";
    public static final String LADDER_SERVICE_URL = "http://wordladder-service";

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
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

    @Bean
    public WordLadderService wordLadderService() {
        return new WordLadderServiceImpl(LADDER_SERVICE_URL);
    }
}

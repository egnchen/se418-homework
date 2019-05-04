package com.eyek.microwordladder.gateway.service;

import com.eyek.microwordladder.gateway.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private String serviceUrl;

    public AuthenticationServiceImpl(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ?
                serviceUrl : "http://" + serviceUrl;
    }

    @Override
    public boolean authenticate(String token) {
        String response = restTemplate.postForObject(
                serviceUrl + "/auth", token, String.class);
        System.out.println(response);
        return response.equals("OK");
    }

    @Override
    public String getAuthUrl(){
        return serviceUrl + "/get-token";
    }

    @Override
    public String login(UserDto userDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", userDto.getUsername());
        params.add("password", userDto.getPassword());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(getAuthUrl(), request, String.class);
    }
}

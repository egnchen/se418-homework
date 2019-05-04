package com.eyek.microwordladder.gateway.service;

import com.eyek.microwordladder.gateway.dto.WordLadderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import java.net.URL;
import java.net.URLEncoder;

public class WordLadderServiceImpl implements WordLadderService {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    private String serviceUrl;

    public WordLadderServiceImpl(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ?
                serviceUrl : "http://" + serviceUrl;
    }

    @Override
    public WordLadderDto getWordLadder(String src, String dst, String token) {
        String url = String.format("%s/get-ladder?src=%s&dst=%s&token=%s", serviceUrl, src, dst, token);
        try {
            WordLadderDto wordLadderDto = restTemplate.getForObject(url, WordLadderDto.class);
            return wordLadderDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

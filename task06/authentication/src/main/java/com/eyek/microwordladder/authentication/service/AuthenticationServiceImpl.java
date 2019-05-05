package com.eyek.microwordladder.authentication.service;

import com.eyek.microwordladder.authentication.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static Map<String, String> authorizedUsers = new HashMap<>();

    private static Map<String, String> defaultIdentities;
    static {
        defaultIdentities = new HashMap<>();
        defaultIdentities.put("root", "secret");
        defaultIdentities.put("Tom", "tomSecret");
        defaultIdentities.put("Jerry", "jerrySecret");
    }

    @Override
    public boolean authenticate(UserDto userDto) {
        // the most dummy, silly and intuitive implementation
        return defaultIdentities.get(userDto.getUsername()).equals(userDto.getPassword());
    }

    @Override
    public String generateToken(UserDto userDto) {
        if(!authenticate(userDto))
            return null;
        String uuid = UUID.randomUUID().toString();
        authorizedUsers.put(uuid, userDto.getUsername());
        return uuid;
    }

    @Override
    public boolean checkToken(String token) {
        System.out.println("Current tokens:");
        for(String tokens: authorizedUsers.keySet()) {
            System.out.println(tokens + " " + authorizedUsers.get(tokens));
        }
        return authorizedUsers.containsKey(token);
    }
}

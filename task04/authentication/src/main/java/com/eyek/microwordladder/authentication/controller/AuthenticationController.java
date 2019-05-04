package com.eyek.microwordladder.authentication.controller;

import com.eyek.microwordladder.authentication.dto.UserDto;
import com.eyek.microwordladder.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/get-token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getToken(UserDto userDto, HttpServletResponse response) {
        try {
            String token = authenticationService.generateToken(userDto);
            if (token != null) {
                response.setHeader("Auth-Token", token);
                return token;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/auth")
    public String authenticate(@RequestBody String token) {
        return authenticationService.checkToken(token) ? "OK" : "Error";
    }
}

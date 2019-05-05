package com.eyek.microwordladder.gateway.service;

import com.eyek.microwordladder.gateway.dto.UserDto;

public interface AuthenticationService {
    public boolean authenticate(String token);
    public String getAuthUrl();
    public String login(UserDto userDto);
}

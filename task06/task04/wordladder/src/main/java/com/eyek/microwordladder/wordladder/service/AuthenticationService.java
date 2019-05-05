package com.eyek.microwordladder.wordladder.service;

import com.eyek.microwordladder.wordladder.dto.UserDto;

public interface AuthenticationService {
    public boolean authenticate(String token);
    public String getAuthUrl();
    public String login(UserDto userDto);
}

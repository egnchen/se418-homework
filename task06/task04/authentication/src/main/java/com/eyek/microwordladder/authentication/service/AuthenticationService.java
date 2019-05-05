package com.eyek.microwordladder.authentication.service;

import com.eyek.microwordladder.authentication.dto.UserDto;

public interface AuthenticationService {
    public boolean authenticate(UserDto userDto);
    public String generateToken(UserDto userDto);
    public boolean checkToken(String token);
}

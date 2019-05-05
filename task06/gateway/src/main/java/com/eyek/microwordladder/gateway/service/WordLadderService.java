package com.eyek.microwordladder.gateway.service;

import com.eyek.microwordladder.gateway.dto.WordLadderDto;

public interface WordLadderService {
    WordLadderDto getWordLadder(String src, String dst, String token);
}

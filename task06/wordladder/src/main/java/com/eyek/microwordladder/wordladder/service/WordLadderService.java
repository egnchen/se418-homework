package com.eyek.microwordladder.wordladder.service;

import com.eyek.microwordladder.wordladder.model.WordLadder;

public interface WordLadderService {
    WordLadder getLadder(String src, String dst);
}

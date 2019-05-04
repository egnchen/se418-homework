package com.eyek.microwordladder.wordladder.controller;

import com.eyek.microwordladder.wordladder.model.WordLadder;
import com.eyek.microwordladder.wordladder.service.AuthenticationService;
import com.eyek.microwordladder.wordladder.service.WordLadderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordLadderServiceController {

    @Autowired
    WordLadderService wordLadderService;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping(value = "/get-ladder", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody WordLadder getWordLadder(
            @RequestParam(value="src", defaultValue = "") String src,
            @RequestParam(value="dst", defaultValue = "") String dst,
            @RequestParam String token) {
        if(!authenticationService.authenticate(token)) {
            // authenticate first
            return new WordLadder("Error: unauthorized request", src, dst, null);
        }
        return wordLadderService.getLadder(src, dst);
    }
}

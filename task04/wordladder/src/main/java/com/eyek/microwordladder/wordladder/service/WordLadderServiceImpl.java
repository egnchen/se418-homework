package com.eyek.microwordladder.wordladder.service;

import com.eyek.microwordladder.wordladder.model.WordLadder;
import com.eyek.microwordladder.wordladder.utils.WordLadderSolver;
import org.springframework.stereotype.Service;

@Service
public class WordLadderServiceImpl implements WordLadderService {

    private WordLadderSolver wordLadderSolver;
    private int dictionaryLength;

    public WordLadderServiceImpl() {
        wordLadderSolver = new WordLadderSolver();
        dictionaryLength = -1;
    }

    @Override
    public WordLadder getLadder(String src, String dst){
        try {
            if (src.length() == dst.length()) {
                if (dictionaryLength != src.length()) {
                    dictionaryLength = src.length();
                    wordLadderSolver.loadDictionary(dictionaryLength);
                }
                return new WordLadder("OK", src, dst, wordLadderSolver.findLadder(src, dst));
            } else
                return new WordLadder("input error", src, dst, null);
        } catch (Exception e) {
            // IO Exception or FileNotFoundException
            return new WordLadder("Internal error, check actuator", src, dst, null);
        }
    }
}

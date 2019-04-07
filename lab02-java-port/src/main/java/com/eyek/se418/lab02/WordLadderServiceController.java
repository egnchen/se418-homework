package com.eyek.se418.lab02;

import com.eyek.se418.lab02.models.WordLadder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordLadderServiceController {
    @RequestMapping(path = { "/get-ladder" }, method= RequestMethod.GET)
    public WordLadder getWordLadder(
            @RequestParam(value="src", defaultValue = "") String src,
            @RequestParam(value="dst", defaultValue = "") String dst ){
        WordLadderSolver solver = new WordLadderSolver();
        if(src.length() == 0 || src.length() != dst.length()) {
            return new WordLadder("input error", src, dst, null);
        }
        try {
            solver.loadDictionary(src.length());
            return new WordLadder("OK", src, dst, solver.findLadder(src, dst));

        } catch (Exception e) {
            return new WordLadder("internal error", src, dst, null);
        }
    }
}

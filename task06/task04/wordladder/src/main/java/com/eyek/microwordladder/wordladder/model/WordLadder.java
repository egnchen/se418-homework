package com.eyek.microwordladder.wordladder.model;

import java.util.ArrayList;

public class WordLadder {
    private final String state;
    private final String src;
    private final String dst;
    private final ArrayList<String> ladder;

    public WordLadder(String state, String src, String dst, ArrayList<String> ladder) {
        this.state = state;
        this.src = src;
        this.dst = dst;
        this.ladder = ladder;
    }

    public String getState() { return state; }

    public String getSrc() {
        return src;
    }

    public String getDst() {
        return dst;
    }

    public ArrayList<String> getLadder() {
        return ladder;
    }
}

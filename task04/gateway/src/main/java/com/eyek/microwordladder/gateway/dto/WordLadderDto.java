package com.eyek.microwordladder.gateway.dto;

import java.util.ArrayList;

public class WordLadderDto {
    private String state;
    private String src;
    private String dst;
    private ArrayList<String> ladder;

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

    public void setState(String state) {
        this.state = state;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public void setLadder(ArrayList<String> ladder) {
        this.ladder = ladder;
    }
}


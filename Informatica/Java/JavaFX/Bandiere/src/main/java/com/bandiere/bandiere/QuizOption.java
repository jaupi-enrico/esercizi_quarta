package com.bandiere.bandiere;
import java.util.ArrayList;

public class QuizOption {
    private String imgSrc;
    private ArrayList<String> opzioni;
    private String opzioneCorretta;

    public QuizOption(String imgSrc, ArrayList<String> opzioni, String opzioneCorretta) {
        this.imgSrc = imgSrc;
        this.opzioni = opzioni;
        this.opzioneCorretta = opzioneCorretta;
    }

    public boolean checkCorretta(String s) {
        return s.equals(opzioneCorretta);
    }

    public ArrayList<String> getOpzioni() {
        return opzioni;
    }

    public String getOpzioni(int index) {
        return getOpzioni().get(index);
    }

    public String getImgSrc() {
        return imgSrc;
    }
}

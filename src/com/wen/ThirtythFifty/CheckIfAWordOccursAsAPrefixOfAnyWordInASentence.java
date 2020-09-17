package com.wen.ThirtythFifty;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split=sentence.split("\\s");
        int l=split.length, wl=searchWord.length();
        for(int i=0; i<l; i++){
            if(split[i].length()>=wl && split[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}

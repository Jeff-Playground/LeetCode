package com.wen.FifteenthFifty;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] lettersCount=new int[26];
        int total=0;
        for(char c: licensePlate.toCharArray()){
            if(isLetter(c)){
                char lowerC=toLowerCase(c);
                lettersCount[lowerC-'a']++;
                total++;
            }
        }
        int max=-1;
        String result="";
        for(String word: words){
            if(max==-1 || max>word.length()){
                int[] curCount=new int[26];
                int curTotal=0;
                for(char c: word.toCharArray()){
                    if(lettersCount[c-'a']>curCount[c-'a']){
                        curCount[c-'a']++;
                        if(++curTotal==total){
                            result=word;
                            max=word.length();
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isLetter(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }

    private char toLowerCase(char c){
        return (c>='a' && c<='z')?c:(char)(c-('A'-'a'));
    }
}

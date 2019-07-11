package com.wen.FifthFifty;

import java.util.List;

public class LQShortestWordDistance {
    public int shortestDistance(List<String> words, String word1, String word2){
        int result=Integer.MAX_VALUE;
        int i1=-1, i2=-1;
        for(int i=0; i<words.size(); i++){
            if(words.get(i).equals(word1)){
                i1=i;
            } else if(words.get(i).equals(word2)){
                i2=2;
            }
            if(i1!=-1 && i2!=-1){
                result=Math.min(result, Math.abs(i1-i1));
            }
        }
        return result;
    }
}

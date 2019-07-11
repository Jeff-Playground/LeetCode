package com.wen.FifthFifty;

import java.util.List;

public class LQShortestWordDistanceIII {
    public int shortestDistance(List<String> words, String word1, String word2){
        int result=Integer.MAX_VALUE;
        int idx1=-1, idx2=-1;
        for(int i=0; i<words.size(); i++){
            if(words.get(i).equals(word1)){
                idx1=word1.equals(word2)?idx2:i;
            }
            if(words.get(i).equals(word2)){
                idx2=i;
            }
            if(idx1!=-1 && idx2!=-1){
                result=Math.min(result, Math.abs(idx1-idx2));
            }
        }
        return result;
    }
}

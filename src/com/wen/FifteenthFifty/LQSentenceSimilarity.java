package com.wen.FifteenthFifty;

import java.util.*;

public class LQSentenceSimilarity {
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        int l1=words1.length, l2=words2.length;
        if(l1!=l2){
            return false;
        }
        Map<String, Set<String>> map=new HashMap<>();
        for(List<String> pair: pairs){
            map.putIfAbsent(pair.get(0), new HashSet<>());
            map.putIfAbsent(pair.get(1), new HashSet<>());
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }
        for(int i=0; i<l1; i++){
            if(!words1[i].equals(words2[i])){
                if(!map.get(words1[i]).contains(words2[i]) && !map.get(words2[i]).contains(words1[i])){
                    return false;
                }
            }
        }
        return true;
    }
}

package com.wen.TenthFifty;

import java.util.*;

public class ConcatenatedWords {
    // DFS
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result=new ArrayList<>();
        Set<String> wordsSet=new HashSet<>(Arrays.asList(words));
        Map<String, Integer> found=new HashMap<>();
        found.put("", 0);
        for(String word: words){
            if(findHelper(word, wordsSet, found)>1){
                result.add(word);
            }
        }
        return result;
    }

    private int findHelper(String pattern, Set<String> wordsSet, Map<String, Integer> found){
        if(found.containsKey(pattern)){
            return found.get(pattern);
        } else{
            int l=pattern.length(), result=0;
            for(int j=0; j<l; j++){
                if(wordsSet.contains(pattern.substring(0, j+1))){
                    String key=pattern.substring(j+1);
                    findHelper(key, wordsSet, found);
                    if(found.containsKey(key)){
                        result=Math.max(result, 1+found.get(key));
                        if(result>2){
                            break;
                        }
                    }
                }
            }
            if(result>0){
                found.put(pattern, result);
            }
            return result;
        }
    }
}

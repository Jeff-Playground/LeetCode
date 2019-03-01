package com.wen.ThirdFifty;

import java.util.*;

public class WordBreakII {
    // Need a HashMap to retain for strings processed for optimization, otherwise will fail the OP time limit
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> known=new HashMap<>();
        return wordBreakDFS(s, wordDict, known);
    }

    private static List<String> wordBreakDFS(String s, List<String> wordDict, Map<String, List<String>> known) {
        if(known.containsKey(s)){
            return known.get(s);
        }
        if(s.isEmpty()){
            return new ArrayList<String>(Arrays.asList(""));
        }
        List<String> result=new ArrayList<>();
        for(String word: wordDict){
            if(word.length()<=s.length()){
                if(!s.substring(0, word.length()).equals(word)){
                    continue;
                }
                List<String> remainResult=wordBreakDFS(s.substring(word.length()), wordDict, known);
                for(String element: remainResult){
                    result.add(word+(element.isEmpty()?"":" "+element));
                }
            }
        }
        known.put(s, result);
        return known.get(s);
    }
}

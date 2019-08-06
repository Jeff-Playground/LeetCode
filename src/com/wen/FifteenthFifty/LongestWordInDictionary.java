package com.wen.FifteenthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public static String longestWord(String[] words) {
        if(words==null || words.length==0){
            return "";
        }
        Arrays.sort(words);
        String result="";
        Set<String> set=new HashSet<>();
        for(String word: words){
            int l=word.length();
            if(l==1 || set.contains(word.substring(0, l-1))){
                if(l>result.length()){
                    result=word;
                }
                set.add(word);
            }
        }
        return result;
    }
}

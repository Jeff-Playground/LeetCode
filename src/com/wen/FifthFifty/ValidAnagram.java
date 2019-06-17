package com.wen.FifthFifty;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] occurrence=new int[26];
        for(char c: s.toCharArray()){
            occurrence[c-'a']++;
        }
        for(char c: t.toCharArray()){
            if(--occurrence[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}

package com.wen.NinthFifty;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int l=s.length();
        Map<Character, Integer> count=new HashMap<>();
        for(char c: s.toCharArray()){
            int cur=count.getOrDefault(c, 0);
            count.put(c, cur+1);
        }
        int oddCount=0;
        for(char c: count.keySet()){
            if(count.get(c)%2==1){
                oddCount+=1;
            }
        }
        return oddCount>1?l-oddCount+1:l;
    }
}

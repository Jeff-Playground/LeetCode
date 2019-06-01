package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    // Sliding window
    public List<Integer> findAnagrams(String s, String p) {
        int l=p.length();
        List<Integer> result=new ArrayList<>();
        if(s==null || s.length()<l){
            return result;
        }
        int[] dict=new int[26];
        int[] window=new int[26];
        for(char c: p.toCharArray()){
            dict[c-'a']++;
        }
        int left=0, right=0, count=0;
        while(right<s.length()){
            char c=s.charAt(right);
            if(++window[c-'a']<=dict[c-'a']){
                count++;
                if(count==l){
                    result.add(left);
                    window[s.charAt(left++)-'a']--;
                    count--;
                }
                right++;
            } else{
                if(dict[c-'a']==0){
                    count=0;
                    left=right+1;
                    right++;
                    Arrays.fill(window, 0);
                } else{
                    while(window[c-'a']>dict[c-'a']){
                        if(c!=s.charAt(left)) {
                            count--;
                        }
                        window[s.charAt(left++)-'a']--;
                    }
                    right++;
                }
            }
        }
        return result;
    }
}

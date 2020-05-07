package com.wen.SeventhFifty;

import java.util.HashMap;
import java.util.Map;

public class LQLongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.isEmpty() || k<=0){
            return 0;
        }
        int result=1, l=s.length(), left=0, right=0;
        Map<Character, Integer> idx=new HashMap<>();
        idx.put(s.charAt(right), right);
        while(l-left>result && right<l){
            if(idx.size()<=k){
                result=Math.max(result, right-left+1);
                right++;
                if(right<l){
                    idx.put(s.charAt(right), right);
                }
            } else{
                while(idx.get(s.charAt(left))!=left){
                    left++;
                }
                idx.remove(s.charAt(left++));
            }
        }
        return result;
    }
}

package com.wen.NinthFifty;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int result=k+1, l=s.length();
        if(l<=result){
            return l;
        }
        int left=0, right=0, max=0;
        Map<Character, Integer> count=new HashMap<>();
        while(left<=right && right<l){
            char cr=s.charAt(right);
            int val=count.getOrDefault(cr, 0)+1, cur=right-left+1;
            max=Math.max(max, val);
            count.put(cr, val);
            right++;
            if(max<cur-k){
                char cl=s.charAt(left++);
                count.put(cl, count.get(cl)-1);
            } else{
                result=Math.max(result, cur);
            }
        }
        return result;
    }
}

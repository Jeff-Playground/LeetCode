package com.wen.FirstFifty;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int length=0;
        int left=0, right=0;
        Set<Character> chars = new HashSet<Character>();
        while(right<s.length()){
            if(!chars.contains(s.charAt(right))){
                chars.add(s.charAt(right++));
                length = Math.max(length, chars.size());
            }else{
                chars.remove(s.charAt(left++));
            }
        }
        return length;
    }
}

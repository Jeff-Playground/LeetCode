package com.wen.FirstFifty;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
//    public static int lengthOfLongestSubstring(String s) {
//        int length=0;
//        int left=0, right=0;
//        Set<Character> chars = new HashSet<Character>();
//        while(right<s.length()){
//            if(!chars.contains(s.charAt(right))){
//                chars.add(s.charAt(right++));
//                length = Math.max(length, chars.size());
//            }else{
//                chars.remove(s.charAt(left++));
//            }
//        }
//        return length;
//    }

    // Use an array to track occurrence instead of a map, the array length is 256(length of extended ASCII)
    public static int lengthOfLongestSubstring(String s) {
        int result=0;
        int[] occurrence=new int[256];
        int left=0, right=0;
        while(right<s.length()){
            if(occurrence[s.charAt(right)]==0){
                occurrence[s.charAt(right)]=1;
                right++;
                result=Math.max(result, right-left+1);
            } else{
                occurrence[s.charAt(left)]=0;
                left++;
            }
        }
        return result;
    }
}

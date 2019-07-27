package com.wen.SeventhFifty;

import java.util.HashMap;
import java.util.Map;

public class LQLongestSubstringWithAtMosKDistinctCharacters {
    // Map stores the count of chars
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.isEmpty() || k<=0){
            return 0;
        }
        int left=0, right=0;
        int result=0;
        Map<Character, Integer> map=new HashMap<>();
        while(right<s.length() && left<=right){
            if(map.size()<k || map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
                right++;
            } else{
                while(map.size()==k){
                    if(map.get(s.charAt(left))==1){
                        map.remove(s.charAt(left));
                    } else{
                        map.put(s.charAt(left), map.get(s.charAt(left))-1);
                    }
                    left++;
                }
            }
            result=Math.max(result,right-left);
        }
        return result;
    }

//    // Map stores the latest index of chars
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if(s==null || s.isEmpty() || k<=0){
//            return 0;
//        }
//        int left=0, right=0;
//        int result=0;
//        Map<Character, Integer> map=new HashMap<>();
//        while(right<s.length() && left<=right){
//            if(map.size()<k || map.containsKey(s.charAt(right))){
//                map.put(s.charAt(right), right);
//                right++;
//            } else{
//                while(map.size()==k){
//                    if(map.get(s.charAt(left))==left){
//                        map.remove(s.charAt(left));
//                    }
//                    left++;
//                }
//            }
//            result=Math.max(result,right-left);
//        }
//        return result;
//    }
}

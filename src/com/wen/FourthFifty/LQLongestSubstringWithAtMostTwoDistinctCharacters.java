package com.wen.FourthFifty;

import java.util.HashMap;
import java.util.Map;

public class LQLongestSubstringWithAtMostTwoDistinctCharacters {
    // Only works for k=2
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        int start=0, rightOfFirstChar=-1;
        int result=0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                continue;
            }
            if(rightOfFirstChar>=0 && s.charAt(rightOfFirstChar)!=s.charAt(i)){
                result=Math.max(result, i-start);
                start=rightOfFirstChar+1;
            }
            rightOfFirstChar=i-1;
        }
        return Math.max(s.length()-start, result);
    }

//    // k=2 for General2
//    public static int lengthOfLongestSubstringTwoDistinct(String s) {
//        if(s==null || s.isEmpty()){
//            return 0;
//        }
//        int left=0, right=0;
//        int result=0;
//        Map<Character, Integer> map=new HashMap<>();
//        while(right<s.length() && left<=right){
//            if(map.size()<2 || map.containsKey(s.charAt(right))){
//                map.put(s.charAt(right), right);
//                right++;
//            } else{
//                while(map.size()==2){
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

//    // General2
//    public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
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

//    // k=2 for General1
//    public static int lengthOfLongestSubstringTwoDistinct(String s) {
//        if(s==null || s.isEmpty()){
//            return 0;
//        }
//        int left=0, right=0;
//        int result=0;
//        Map<Character, Integer> map=new HashMap<>();
//        while(right<s.length() && left<=right){
//            if(map.size()<2 || map.containsKey(s.charAt(right))){
//                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
//                right++;
//            } else{
//                while(map.size()==2){
//                    if(map.get(s.charAt(left))==1){
//                        map.remove(s.charAt(left));
//                    } else{
//                        map.put(s.charAt(left), map.get(s.charAt(left))-1);
//                    }
//                    left++;
//                }
//            }
//            result=Math.max(result,right-left);
//        }
//        return result;
//    }

//    // General
//    public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
//        if(s==null || s.isEmpty() || k<=0){
//            return 0;
//        }
//        int left=0, right=0;
//        int result=0;
//        Map<Character, Integer> map=new HashMap<>();
//        while(right<s.length() && left<=right){
//            if(map.size()<k || map.containsKey(s.charAt(right))){
//                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
//                right++;
//            } else{
//                while(map.size()==k){
//                    if(map.get(s.charAt(left))==1){
//                        map.remove(s.charAt(left));
//                    } else{
//                        map.put(s.charAt(left), map.get(s.charAt(left))-1);
//                    }
//                    left++;
//                }
//            }
//            result=Math.max(result,right-left);
//        }
//        return result;
//    }
}

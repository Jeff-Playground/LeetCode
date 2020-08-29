package com.wen.SecondFifty;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
//    // Map also contains characters from s, this is more of a justification in HashMap for the Array solution, not practical
//    public String minWindow(String s, String t) {
//        String res="";
//        if(t.length()>s.length()) {
//            return res;
//        }
//        Map<Character, Integer> tMap=new HashMap<Character, Integer>();
//        int left=0, count=0, minLen=s.length()+1;
//        for(char c: t.toCharArray()) {
//            tMap.put(c, tMap.getOrDefault(c, 0)+1);
//        }
//        for(int i=0; i<s.length(); i++) {
//            char c=s.charAt(i);
//            if(tMap.getOrDefault(c, 0)>0) {
//                count++;
//            }
//            tMap.put(c, tMap.getOrDefault(c, 0)-1);
//            while(count==t.length()) {
//                if(minLen>i-left+1) {
//                    minLen=i-left+1;
//                    res=s.substring(left, i+1);
//                }
//                char leftChar=s.charAt(left);
//                tMap.put(leftChar, tMap.get(leftChar)+1);
//                if(tMap.get(leftChar)>0) {
//                    count--;
//                }
//                left++;
//            }
//        }
//        return res;
//    }

//    // Integer array
//    public String minWindow(String s, String t) {
//        String res="";
//        if(t.length()>s.length()) {
//            return res;
//        }
//        int[] tArray=new int[256];
//        int left=0, count=0, minLen=s.length()+1;
//        for(char c: t.toCharArray()) {
//            tArray[(int)c]++;
//        }
//        for(int i=0; i<s.length(); i++) {
//            char c=s.charAt(i);
//            if(--tArray[(int)c]>=0) {   // This puts the array values of chars in s but not in t to negative values
//                count++;
//            }
//            while(count==t.length()) {
//                if(minLen>i-left+1) {
//                    minLen=i-left+1;
//                    res=s.substring(left, i+1);
//                }
//                char leftChar=s.charAt(left);
//                if(++tArray[(int)leftChar]>0) { // This will be OK because other chars in s but not in t will have a value <=0
//                    count--;
//                }
//                left++;
//            }
//        }
//        return res;
//    }

    // Slinding window, Map only contains character from t
    public static String minWindow(String s, String t) {
        String result="";
        if(t.length()>s.length()) {
            return result;
        }
        Map<Character, Integer> tMap=new HashMap<>();
        for(char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }
        int left=0, right=0, count=0, minLen=s.length()+1;
        while(right<=s.length()){
            char c=right<s.length()?s.charAt(right):'$';
            if(tMap.containsKey(c)){
                tMap.put(c, tMap.get(c)-1);
                if(tMap.get(c)>=0) {
                    count++;
                }
            }
            right++;
            while(count==t.length()){
                c=s.charAt(left);
                while(!tMap.containsKey(c) || tMap.get(c)<0){
                    if(tMap.containsKey(c)){
                        tMap.put(c, tMap.get(c)+1);
                    }
                    c=s.charAt(++left);
                }
                if(minLen>right-left){
                    minLen=right-left;
                    result=s.substring(left, right);
                }
                tMap.put(c, tMap.get(c)+1);
                count--;
                left++;
            }
        }
        return result;
    }
}

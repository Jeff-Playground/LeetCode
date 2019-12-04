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

    // Integer array
    public String minWindow(String s, String t) {
        String res="";
        if(t.length()>s.length()) {
            return res;
        }
        int[] tArray=new int[256];
        int left=0, count=0, minLen=s.length()+1;
        for(char c: t.toCharArray()) {
            tArray[(int)c]++;
        }
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            if(--tArray[(int)c]>=0) {   // This puts the array values of chars in s but not in t to negative values
                count++;
            }
            while(count==t.length()) {
                if(minLen>i-left+1) {
                    minLen=i-left+1;
                    res=s.substring(left, i+1);
                }
                char leftChar=s.charAt(left);
                if(++tArray[(int)leftChar]>0) { // This will be OK because other chars in s but not in t will have a value <=0
                    count--;
                }
                left++;
            }
        }
        return res;
    }

//    // Map only contains character from t
//    public String minWindow(String s, String t) {
//        String res="";
//        if(t.length()>s.length()) {
//            return res;
//        }
//        Map<Character, Integer> tMap=new HashMap<Character, Integer>();
//        int left=0, count=0, minLen=s.length()+1;
//        for(char c: t.toCharArray()) {
//            if(tMap.containsKey(c)) {
//                tMap.put(c, tMap.get(c)+1);
//            } else {
//                tMap.put(c, 1);
//            }
//        }
//        for(int i=0; i<s.length(); i++) {
//            char c=s.charAt(i);
//            if(tMap.containsKey(c)) {
//                if(tMap.get(c)>0) {
//                    count++;
//                }
//                tMap.put(c, tMap.get(c).intValue()-1);
//            }
//            while(count==t.length()) {
//                if(minLen>i-left+1) {
//                    minLen=i-left+1;
//                    res=s.substring(left, i+1);
//                }
//                char leftChar=s.charAt(left);
//                if(tMap.containsKey(leftChar)) {
//                    tMap.put(leftChar, tMap.get(leftChar)+1);
//                    if(tMap.get(leftChar)>0){
//                        count--;
//                    }
//                    left++;
//                    while(left<s.length() && !tMap.containsKey(s.charAt(left))) {
//                        left++;
//                    }
//                    if(left>=s.length()) {
//                        return res;
//                    }
//                } else {
//                    left++;
//                }
//            }
//        }
//        return res;
//    }
}

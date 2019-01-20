package com.wen.SecondFifty;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // Map only contains characters from s
    public String minWindow(String s, String t) {
        String res="";
        if(t.length()>s.length()) {
            return res;
        }
        Map<Character, Integer> tMap=new HashMap<Character, Integer>();
        int left=0, count=0, minLen=s.length()+1;
        for(char c: t.toCharArray()) {
            if(tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c)+1);
            } else {
                tMap.put(c, 1);
            }
        }
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            if(tMap.containsKey(c)) {
                if(tMap.get(c)>0) {
                    count++;
                }
                tMap.put(c, tMap.get(c).intValue()-1);
            } else {
                tMap.put(c, -1);
            }
            while(count==t.length()) {
                if(minLen>i-left+1) {
                    minLen=i-left+1;
                    res=s.substring(left, i+1);
                }
                char leftChar=s.charAt(left);
                if(tMap.get(leftChar)>=0) {
                    count--;
                }
                tMap.put(leftChar, tMap.get(leftChar).intValue()+1);
                left++;
            }
        }
        return res;
    }

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
//            if(--tArray[(int)c]>=0) {
//                count++;
//            }
//            while(count==t.length()) {
//                if(minLen>i-left+1) {
//                    minLen=i-left+1;
//                    res=s.substring(left, i+1);
//                }
//                char leftChar=s.charAt(left);
//                if(++tArray[(int)leftChar]>0) {
//                    count--;
//                }
//                left++;
//            }
//        }
//        return res;
//    }

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
//                    if(tMap.get(leftChar)<0) {
//                        count++;
//                    }
//                    tMap.put(leftChar, tMap.get(leftChar)+1);
//                    count--;
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

package com.wen.FifthFifty;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    // Two arrays instead of two Maps
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) {
            return false;
        }
        int[] mapS=new int[256];
        int[] mapT=new int[256];
        for(int i=0; i<s.length(); i++) {
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);
            if(mapS[sChar]!=mapT[tChar]) {
                return false;
            }
            // Use i+1 because the array init values are 0, need to differenciate it with index 0
            mapS[sChar]=i+1;
            mapT[tChar]=i+1;
        }
        return true;
    }

//    // Two Maps
//    public boolean isIsomorphic(String s, String t) {
//        if(s==null || t==null || s.length()!=t.length()) {
//            return false;
//        }
//        Map<Character, Character> mapS=new HashMap<>();
//        Map<Character, Character> mapT=new HashMap<>();
//        for(int i=0; i<s.length(); i++) {
//            char sChar=s.charAt(i);
//            char tChar=t.charAt(i);
//            if(mapS.containsKey(sChar)) {
//                if(mapS.get(sChar)!=tChar) {
//                    return false;
//                }
//            } else {
//                mapS.put(sChar, tChar);
//            }
//            if(mapT.containsKey(tChar)) {
//                if(mapT.get(tChar)!=sChar) {
//                    return false;
//                }
//            } else {
//                mapT.put(tChar, sChar);
//            }
//        }
//        return true;
//    }
}

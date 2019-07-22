package com.wen.SixthFifty;

import java.util.HashSet;
import java.util.Set;

public class LQPalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s==null){
            return false;
        }
        int l=s.length();
        Set<Character> occur=new HashSet<>();
        for(int i=0; i<l; i++){
            char c=s.charAt(i);
            if(occur.contains(c)){
                occur.remove(c);
            } else {
                occur.add(c);
            }
        }
        return occur.size()<=1;
    }

//    public boolean canPermutePalindrome(String s) {
//        if(s==null){
//            return false;
//        }
//        int l=s.length();
//        int[] occur=new int[256];
//        for(int i=0; i<l; i++){
//            char c=s.charAt(i);
//            occur[c]^=1;
//        }
//        int count=0;
//        for(int i=0; i<256; i++){
//            if(occur[i]==1){
//                count++;
//            }
//        }
//        return count<=1;
//    }
}

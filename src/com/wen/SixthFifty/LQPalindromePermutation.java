package com.wen.SixthFifty;

/*
Given a string s, return true if a permutation of the string could form a palindrome.

Example 1:
Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true

Example 3:
Input: s = "carerac"
Output: true


Constraints:
1 <= s.length <= 5000
s consists of only lowercase English letters.
 */

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

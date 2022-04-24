package com.wen.FourthFifty;

/*
Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

Insert exactly one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.


Example 1:
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.


Example 2:
Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.


Constraints:
0 <= s.length, t.length <= 104
s and t consist of lowercase letters, uppercase letters, and digits.
 */

public class LQOneEditDistance {
//    // Same idea with simplified code
//    public boolean isOneEditDistance(String s, String t) {
//        if(s.length()<t.length()){
//            return isOneEditDistance(t, s);
//        }
//        for(int i=0; i<t.length(); i++){
//            if(s.charAt(i)!=t.charAt(i)){
//                if(s.length()==t.length()){
//                    return s.substring(i+1).equals(t.substring(i+1));
//                } else{
//                    return s.substring(i+1).equals(t.substring(i));
//                }
//            }
//        }
//        return s.length()-t.length()==1;
//    }

    public boolean isOneEditDistance(String s, String t) {
        if(s.length()<t.length()){
            return isOneEditDistance(t, s);
        }
        int m=s.length(), n=t.length(), diff=m-n;
        if(diff>1){
            return false;
        } else if(diff==1){
            for(int i=0; i<n; i++){
                if(s.charAt(i)!=t.charAt(i)){
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
            return true;
        } else{
            int count=0;
            for(int i=0; i<n; i++){
                if(s.charAt(i)!=t.charAt(i)){
                    count++;
                }
            }
            return count==1;
        }
    }
}

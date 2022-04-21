package com.wen.ThirteenthFifty;

/*

Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings
in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag.
Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

Example 1:

Input:
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"


Example 2:

Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"


Note:

The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].

*/

import java.util.*;

public class LQAddBoldTagInString {
    public static String addBoldTag(String s, String[] dict) {
        int l=s.length();
        boolean[] exist=new boolean[l];
        int end=-1;
        for(int i=0; i<l; i++){
            for(String word: dict){
                int len=word.length();
                if(i+len<=l && s.substring(i, i+len).equals(word)){
                    end=Math.max(end, i+len);
                }
            }
            // Note here end is the maximum right reach, and could be from previous match
            exist[i]=end>i;
        }
        StringBuilder sb=new StringBuilder();
        int size=0;
        for(int i=0; i<=l; i++){
            if(i<l && exist[i]){
                size++;
            } else{
                if(size>0){
                    sb.append("<b>"+s.substring(i-size, i)+"</b>");
                    size=0;
                }
                if(i<l){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

//    public String addBoldTag(String s, String[] dict) {
//        int l=s.length();
//        Set<Integer> matchedIdx=new HashSet<>();
//        for(String word: dict){
//            int len=word.length();
//            for(int i=0; i<=l-len; i++){
//                if(s.substring(i, i+len).equals(word)){
//                    for(int j=i; j<i+len; j++){
//                        matchedIdx.add(j);
//                    }
//                }
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0; i<l; i++){
//            if(matchedIdx.contains(i) && !matchedIdx.contains(i-1)){
//                sb.append("<b>");
//            }
//            sb.append(s.charAt(i));
//            if(matchedIdx.contains(i) && !matchedIdx.contains(i+1)){
//                sb.append("</b>");
//            }
//        }
//        return sb.toString();
//    }
}

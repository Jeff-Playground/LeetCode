package com.wen.EighthFifty;

/*
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least distance 3 from each other.

Example 2:
Input: s = "aaabc", k = 3
Output: ""
Explanation: It is not possible to rearrange the string.

Example 3:
Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LQRearrangeStringKDistanceApart {
    public static String rearrangeString(String str, int k) {
        if(k<=0){
            return "";
        }
        int l=str.length();
        StringBuilder result=new StringBuilder();
        result.setLength(l);
        Map<Character, Integer> count=new HashMap<>();
        for(char c: str.toCharArray()){
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a, b)->(count.get(b)-count.get(a)));
        count.keySet().forEach(a->pq.offer(a));
        int start=0, idx=0;
        while(!pq.isEmpty()){
            char c=pq.poll();
            int time=count.get(c);
            if(time>l/k+1){
                return "";
            } else{
                while(time-->0){
                    result.setCharAt(idx, c);
                    idx+=k;
                    if(idx>=l){
                        idx=++start;
                    }
                }
            }
        }
        return result.toString();
    }
}

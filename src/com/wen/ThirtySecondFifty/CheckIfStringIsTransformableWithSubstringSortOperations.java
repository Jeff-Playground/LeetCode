package com.wen.ThirtySecondFifty;

import java.util.Deque;
import java.util.LinkedList;

public class CheckIfStringIsTransformableWithSubstringSortOperations {
    // The idea is for a digit, it can only move to left when it's smaller than the digits on its left, so here the method
    // is essentially  for each digit in t find the first occurrence in s, and try to move it to the front by checking if
    // there is any smaller one in front of it. If there is, then that's not possible
    public boolean isTransformable(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()){
            return false;
        }
        Deque<Integer>[] idx=new Deque[10];
        for(int i=0; i<10; i++){
            idx[i]=new LinkedList<>();
        }
        for(int i=0; i<s.length(); i++){
            idx[s.charAt(i)-'0'].offerLast(i);
        }
        for(char c: t.toCharArray()){
            int id=c-'0';
            if(idx[id].isEmpty()){
                return false;
            } else{
                int cIdx=idx[id].peekFirst();
                for(int i=0; i<id; i++){
                    if(!idx[i].isEmpty() && idx[i].peekFirst()<cIdx){
                        return false;
                    }
                }
                idx[id].pollFirst();
            }
        }
        return true;
    }
}

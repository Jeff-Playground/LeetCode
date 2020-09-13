package com.wen.ThirtySecondFifty;

import java.util.Deque;
import java.util.LinkedList;

public class CheckIfStringIsTransformableWithSubstringSortOperations {
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

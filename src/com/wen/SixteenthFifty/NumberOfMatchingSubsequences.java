package com.wen.SixteenthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> sMap=new HashMap<>();
        int sl=S.length();
        for(int i=0; i<sl; i++){
            List<Integer> list=sMap.get(S.charAt(i));
            if(list==null){
                list=new ArrayList<>();
                sMap.put(S.charAt(i), list);
            }
            list.add(i);
        }
        int result=0;
        for(String word: words){
            int prev=-1, isBreak=0;
            for(char c: word.toCharArray()){
                List<Integer> list=sMap.get(c);
                if(list==null){
                    isBreak=1;
                    break;
                }
                int left=0, right=list.size()-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(list.get(mid)<=prev){
                        left=mid+1;
                    } else{
                        right=mid-1;
                    }
                }
                if(left>list.size()-1){
                    isBreak=1;
                    break;
                } else{
                    prev=list.get(left);
                }
            }
            if(isBreak==0){
                result++;
            }
        }
        return result;
    }
}

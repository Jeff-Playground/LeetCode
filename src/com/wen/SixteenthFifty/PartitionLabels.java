package com.wen.SixteenthFifty;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result=new ArrayList<>();
        Map<Character, Integer> map=new HashMap<>();
        int l=S.length();
        for(int i=0; i<l; i++){
            map.put(S.charAt(i), i);
        }
        int start=0, last=0, i=0;
        while(i<l){
            last=Math.max(last, map.get(S.charAt(i)));
            if(i==last){
                result.add(last-start+1);
                start=i+1;
            }
            i++;
        }
        return result;
    }
}

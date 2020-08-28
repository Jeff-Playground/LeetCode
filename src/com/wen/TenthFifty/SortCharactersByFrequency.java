package com.wen.TenthFifty;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s==null || s.length()<3){
            return s;
        }
        Map<Character, Integer> count=new HashMap<>();
        for(char c: s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a, b)->count.get(b)-count.get(a));
        for(char c: count.keySet()){
            pq.offer(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.poll();
            int times=count.get(c);
            while(times-->0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

package com.wen.TenthFifty;

import java.util.*;

public class SortCharactersByFrequency {
    class Pair{
        public char c;
        public int v;

        public Pair(char c, int v) {
            this.c=c;
            this.v=v;
        }
    }

    public String frequencySort(String s) {
        if(s==null || s.length()<3){
            return s;
        }
        Map<Character, Integer> map=new LinkedHashMap<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else{
                map.put(c, 1);
            }
        }
        Queue<Pair> pq=new PriorityQueue<>((a,b)->(b.v-a.v));
        for(char c: map.keySet()) {
            pq.offer(new Pair(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p=pq.poll();
            int count=p.v;
            while(count>0) {
                sb.append(p.c);
                count--;
            }
        }
        return sb.toString();
    }
}

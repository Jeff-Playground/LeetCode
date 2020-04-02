package com.wen.TwentyFirstFifty;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for(int stone: stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int s1=pq.poll(), s2=pq.poll();
            if(s1!=s2){
                pq.offer(Math.abs(s1-s2));
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}

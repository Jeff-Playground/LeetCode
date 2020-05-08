package com.wen.EleventhFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int l=Profits.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]!=b[0]?b[0]-a[0]:a[1]-b[1]);
        for(int i=0; i<l; i++){
            pq.offer(new int[]{Profits[i], Capital[i]});
        }
        int count=0;
        while(count++<k){
            List<int[]> cache=new ArrayList<>();
            int[] cur=null;
            while(!pq.isEmpty()){
                cur=pq.poll();
                if(cur[1]<=W){
                    break;
                }
                cache.add(cur);
            }
            if(cur==null || cur[1]>W){
                break;
            } else{
                W+=cur[0];
                cache.forEach(e->pq.offer(e));
            }
        }
        return W;
    }
}

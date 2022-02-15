package com.wen.ThirtyThirdFifty;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    // Max heap, the idea is when current required bricks is more than the bricks we have, then find the largest diff
    // currently and replace it with a ladder
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int l=heights.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        int total=0, i=1;
        for(; i<l; i++){
            int diff=heights[i]-heights[i-1];
            if(diff>0){
                total+=diff;
                pq.offer(diff);
                while(total>bricks && ladders>0){
                    ladders--;
                    total-=pq.poll();
                }
                if(total>bricks){
                    break;
                }
            }
        }
        return i-1;
    }
}

package com.wen.TwentyEighthFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {
    // Greedy
    // The idea is sort all the employees based on efficiency in decreasing order, then do iteration, where each iteration
    // try to form a team with employee i as leader(leader will definitely be in the team). So for each team, leader would
    // always have the least efficiency, therefore the performance calculation for each team has a fixed efficiency. Then
    // sort the employees before leader based on speed in decreasing order, and pick a maximum of k-1 team members to
    // calculate the final performance.
    // Note how sorting the team members' speed use a trick, where we maintain a PriorityQueue of max size k-1, and make
    // it a minHeap, so each time we add a new in scope employee speed, we can easily utilize the work done in previous
    // iterations. If we don't use this trick, the program will become so efficient to fail with TLE
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> sorted=new ArrayList<>();
        for(int i=0; i<n; i++){
            Engineer cur=new Engineer(speed[i], efficiency[i]);
            sorted.add(cur);
        }
        Collections.sort(sorted, (a, b)->b.efficiency-a.efficiency);
        long result=0;
        int mod=1_000_000_007;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long speedSum=0;
        for(int i=0; i<n; i++){
            Engineer lead=sorted.get(i);
            long curSum=lead.speed;
            if(i-1>=0 && k>1){
                int newSpeed=sorted.get(i-1).speed;
                if(pq.size()<k-1){
                    pq.offer(newSpeed);
                    speedSum+=newSpeed;
                } else{
                    if(newSpeed>pq.peek()){
                        speedSum-=pq.poll();
                        pq.offer(newSpeed);
                        speedSum+=newSpeed;
                    }
                }
            }
            curSum+=speedSum;
            result=Math.max(result, curSum*lead.efficiency);
        }
        return (int)(result%mod);
    }

    private class Engineer{
        int speed, efficiency;

        public Engineer(int speed, int efficiency){
            this.speed=speed;
            this.efficiency=efficiency;
        }
    }
}

package com.wen.SixteenthFifty;

import java.util.*;

public class CheapestFlightsWithinKStops {
//    // Bellman-Ford
//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        int[] cost=new int[n];
//        Arrays.fill(cost, Integer.MAX_VALUE);
//        cost[src]=0;
//        for(int i=0; i<=K; i++){
//            int[] last=Arrays.copyOf(cost, n);
//            for(int[] edge: flights){
//                if(last[edge[0]]<Integer.MAX_VALUE && last[edge[0]]+edge[2]<cost[edge[1]]){
//                    cost[edge[1]]=last[edge[0]]+edge[2];
//                }
//            }
//        }
//        return cost[dst]<Integer.MAX_VALUE?cost[dst]:-1;
//    }

    // SPFA
    // Note here the traversal is level by level to ensure no more than K stops
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost=new int[n];
        // int[] count=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(src);
        // count[src]++;
        int cnt=0;
        while(!q.isEmpty() && cnt<=K){
            int size=q.size();
            // Note here introduce last to store last level's state, not required in normal SPFA
            int[] last=Arrays.copyOf(cost, n);
            while(size-->0){
                int cur=q.poll();
                for(int[] flight: flights){
                    // Note last[flight[0]]+flight[2]<cost[flight[1]] to avoid cost affected by nodes from same level(
                    // When it's affected, it adds a stop before the affected node, which makes cnt useless)
                    if(flight[0]==cur && last[flight[0]]+flight[2]<cost[flight[1]]){
                        cost[flight[1]]=last[flight[0]]+flight[2];
                        q.offer(flight[1]);
                        // Logic to determine whether there's a negative loop
                        // Note here normally should be >n-1, but to handle the case when n==1, give N
                        // if(++count[flight[1]]>n){
                        //     return -1;
                        // }
                    }
                }
            }
            cnt++;
        }
        return cost[dst]<Integer.MAX_VALUE?cost[dst]:-1;
    }
}

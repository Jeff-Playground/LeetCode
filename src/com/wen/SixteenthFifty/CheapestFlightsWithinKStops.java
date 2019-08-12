package com.wen.SixteenthFifty;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    // Bellman-Ford
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0; i<=K; i++){
            int[] last=Arrays.copyOf(cost, n);
            for(int[] edge: flights){
                if(last[edge[0]]<Integer.MAX_VALUE && last[edge[0]]+edge[2]<cost[edge[1]]){
                    cost[edge[1]]=last[edge[0]]+edge[2];
                }
            }
        }
        return cost[dst]<Integer.MAX_VALUE?cost[dst]:-1;
    }
}

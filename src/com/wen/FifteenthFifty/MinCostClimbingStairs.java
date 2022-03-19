package com.wen.FifteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {
    // DP2, bottom up
    public static int minCostClimbingStairs(int[] cost) {
        for(int i=2; i<cost.length-1; i++){
            cost[i]+=Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[cost.length-2], cost[cost.length-1]);
    }

//    // DP1, top down
//    public int minCostClimbingStairs(int[] cost) {
//        Map<Integer, Integer> cache=new HashMap<>();
//        cache.put(0, 0);
//        cache.put(1, 0);
//        return mccsHelper(cost, cache, cost.length);
//    }
//
//    private int mccsHelper(int[] cost, Map<Integer, Integer> cache, int i){
//        if(!cache.containsKey(i)){
//            cache.put(i, Math.min(mccsHelper(cost, cache, i-1)+cost[i-1], mccsHelper(cost, cache, i-2)+cost[i-2]));
//        }
//        return cache.get(i);
//    }

//    // DP1, bottom up
//    // min[i] stands for the minimum cost to reach stair i
//    public int minCostClimbingStairs(int[] cost) {
//        int[] min=new int[cost.length+1];
//        for(int i=2; i<=cost.length; i++){
//            min[i]=Math.min(min[i-2]+cost[i-2], min[i-1]+cost[i-1]);
//        }
//        return min[cost.length];
//    }

//    // DP1 optimized as no iteration along 1 dimension - the dimension of stair idx
//    public int minCostClimbingStairs(int[] cost) {
//        int l=cost.length;
//        int first=cost[0], second=cost[1];
//        for(int i=2; i<l; i++){
//            int cur=Math.min(first, second)+cost[i];
//            first=second;
//            second=cur;
//        }
//        return Math.min(first, second);
//    }
}

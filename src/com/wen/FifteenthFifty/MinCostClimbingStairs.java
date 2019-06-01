package com.wen.FifteenthFifty;

public class MinCostClimbingStairs {
    // DP2
    public static int minCostClimbingStairs(int[] cost) {
        for(int i=2; i<cost.length; i++){
            cost[i]+=Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[cost.length-2], cost[cost.length-1]);
    }

//    // DP1
//    public int minCostClimbingStairs(int[] cost) {
//        int[] min=new int[cost.length+1];
//        for(int i=2; i<=cost.length; i++){
//            min[i]=Math.min(min[i-2]+cost[i-2], min[i-1]+cost[i-1]);
//        }
//        return min[cost.length];
//    }
}

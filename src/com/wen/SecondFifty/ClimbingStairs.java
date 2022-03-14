package com.wen.SecondFifty;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    // DP top down
    public int climbStairs(int n) {
        Map<Integer, Integer> cache=new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        return csHelper(n, cache);
    }

    private int csHelper(int n, Map<Integer, Integer> cache){
        if(!cache.containsKey(n)){
            int climbOneLast=csHelper(n-1, cache);
            int climbTwoLast=csHelper(n-2, cache);
            cache.put(n, climbOneLast+climbTwoLast);
        }
        return cache.get(n);
    }

//    // DP bottom up
//    // dp[i] stands for the number of ways to reach stair i+1
//    public int climbStairs(int n) {
//        if(n==1){
//            return 1;
//        }
//        int[] dp=new int[n];
//        dp[0]=1;
//        dp[1]=2;
//        for(int i=2; i<n; i++){
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n-1];
//    }
}

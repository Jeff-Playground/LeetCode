package com.wen.SecondFifty;

public class ClimbingStairs {
    // Iterative
    public int climbStairs(int n) {
        int cur=1, next=1;
        while(n-->0){
            next+=cur;
            cur=next-cur;
        }
        return cur;
    }

//    // Dynamic programming
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

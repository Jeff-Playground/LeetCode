package com.wen.TwentyFourthFifty;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    // DP, bottom up
    // dp[i][j] stands for the number of ways to get a sum j at dice i
    public int numRollsToTarget(int n, int k, int target) {
        if(target<n){
            return 0;
        }
        int mod=1_000_000_007;
        int[][] dp=new int[n][target+1];
        for(int i=0; i<n; i++){
            for(int j=1; j<=target; j++){
                if(i==0){
                    dp[i][j]=j<=k?1:0;
                } else{
                    for(int t=1; t<=k && t<j; t++){
                        dp[i][j]=(dp[i][j]+dp[i-1][j-t])%mod;
                    }
                }
            }
        }
        return dp[n-1][target];
    }

//    // DP, top down
//    public int numRollsToTarget(int n, int k, int target) {
//        if(target<n){
//            return 0;
//        }
//        int[][] memo=new int[n][target+1];
//        for(int[] a: memo){
//            Arrays.fill(a, -1);
//        }
//        return dp(k, n-1, target, memo);
//    }
//
//    private int dp(int k, int idx, int t, int[][] memo){
//        if(memo[idx][t]==-1){
//            if(idx==0){
//                memo[idx][t]=t<=k?1:0;
//            } else{
//                int mod=1_000_000_007;
//                memo[idx][t]=0;
//                for(int i=1; i<=k && i<t; i++){
//                    memo[idx][t]=(memo[idx][t]+dp(k, idx-1, t-i, memo))%mod;
//                }
//            }
//        }
//        return memo[idx][t];
//    }
}

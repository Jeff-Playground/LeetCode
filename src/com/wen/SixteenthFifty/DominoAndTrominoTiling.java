package com.wen.SixteenthFifty;

import java.util.Arrays;

public class DominoAndTrominoTiling {
    // DP, bottom up
    // dp[i][0] stands for the number of ways to partially occupy a space of length i, dp[i][1] stands for the number of
    // ways to fully occupy a space of length i. Note here partially means leave the right bottom corner empty
    public int numTilings(int n) {
        int mod=1_000_000_007;
        int[][] dp=new int[n+1][2];
        for(int i=0; i<=n; i++){
            if(i==0){
                dp[i][0]=0;
                dp[i][1]=1;
            } else if(i==1){
                dp[i][0]=0;
                dp[i][1]=1;
            } else{
                dp[i][0]=(dp[i-2][1]+dp[i-1][0])%mod;
                // 2* to symmetrically rotate the filling and produce another way
                dp[i][1]=((dp[i-1][1]+dp[i-2][1])%mod+(2*dp[i-1][0])%mod)%mod;
            }
        }
        return dp[n][1];
    }

//    // DP, top down
//    public int numTilings(int n) {
//        int[][] memo=new int[n+1][2];
//        for(int[] a: memo){
//            Arrays.fill(a, -1);
//        }
//        return dp(n, 1, memo);
//    }
//
//    private int dp(int idx, int isFull, int[][] memo){
//        if(memo[idx][isFull]==-1){
//            if(idx==0){
//                memo[idx][isFull]=isFull==0?0:1;
//            } else if(idx==1){
//                memo[idx][isFull]=isFull==0?0:1;
//            } else{
//                int mod=1_000_000_007;
//                if(isFull==1){
//                    memo[idx][isFull]=((dp(idx-1, 1, memo)+dp(idx-2, 1, memo))%mod+(2*dp(idx-1, 0, memo))%mod)%mod;
//                } else{
//                    memo[idx][isFull]=(dp(idx-1, 0, memo)+dp(idx-2, 1, memo))%mod;
//                }
//            }
//        }
//        return memo[idx][isFull];
//    }
}

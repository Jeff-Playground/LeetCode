package com.wen.SeventhFifty;

import java.util.Arrays;

public class CoinChange {
//    // DP, unbounded knapsack optimized to one dimensional array
//    public int coinChange(int[] coins, int amount) {
//        int l=coins.length;
//        int[] dp=new int[amount+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0]=0;
//        for(int i=1; i<=l; i++){
//            for(int j=1; j<=amount; j++){
//                if(coins[i-1]<=j && dp[j-coins[i-1]]!=Integer.MAX_VALUE){
//                    dp[j]=Math.min(dp[j], dp[j-coins[i-1]]+1);
//                } else{
//                    dp[j]=dp[j];
//                }
//            }
//        }
//        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
//    }

    // DP, unbounded knapsack
    public int coinChange(int[] coins, int amount) {
        int l=coins.length;
        int[][] dp=new int[l+1][amount+1];
        for(int i=0; i<=l; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0]=0;
        }
        for(int i=1; i<=l; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1]<=j && dp[i][j-coins[i-1]]!=Integer.MAX_VALUE){
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                } else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[l][amount]==Integer.MAX_VALUE?-1:dp[l][amount];
    }

//    // DP, bounded knapsack optimized to one dimensional array
//    public static int coinChange(int[] coins, int amount) {
//        int l=coins.length;
//        int[] dp=new int[amount+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0]=0;
//        for(int i=1; i<=l; i++){
//            for(int j=amount; j>=1; j--){
//                int max=j/coins[i-1];
//                for(int k=max; k>=1; k--){
//                    if(dp[j-k*coins[i-1]]!=Integer.MAX_VALUE){
//                        dp[j]=Math.min(dp[j], dp[j-k*coins[i-1]]+k);
//                    }
//                }
//            }
//        }
//        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
//    }

//    // DP, bounded knapsack, bottom up
//    public int coinChange(int[] coins, int amount) {
//        int l=coins.length;
//        int[][] dp=new int[l+1][amount+1];
//        for(int i=0; i<=l; i++){
//            Arrays.fill(dp[i], -1);
//            dp[i][0]=0;
//        }
//        for(int i=1; i<=l; i++){
//            for(int j=1; j<=amount; j++){
//                int max=j/coins[i-1], min=Integer.MAX_VALUE;
//                for(int k=0; k<=max; k++){
//                    if(dp[i-1][j-k*coins[i-1]]!=-1){
//                        min=Math.min(min, dp[i-1][j-k*coins[i-1]]+k);
//                    }
//                }
//                dp[i][j]=min==Integer.MAX_VALUE?-1:min;
//            }
//        }
//        return dp[l][amount];
//    }

//    // DP, bounded knapsack, top down
//    public int coinChange(int[] coins, int amount) {
//        int l=coins.length;
//        int[][] memo=new int[l][amount+1];
//        return dp(coins, amount, l-1, amount, memo);
//    }
//
//    private int dp(int[] coins, int amount, int idx, int cur, int[][] memo){
//        if(memo[idx][cur]==0){
//            if(cur==0){
//                memo[idx][cur]=0;
//            } else if(idx==0){
//                if(cur%coins[idx]==0){
//                    memo[idx][cur]=cur/coins[idx];
//                } else{
//                    memo[idx][cur]=-1;
//                }
//            } else{
//                int count=cur/coins[idx], min=Integer.MAX_VALUE;
//                for(int i=0; i<=count; i++){
//                    int last=dp(coins, amount, idx-1, cur-coins[idx]*i, memo);
//                    if(last!=-1){
//                        min=Math.min(last+i, min);
//                    }
//                }
//                memo[idx][cur]=min==Integer.MAX_VALUE?-1:min;
//            }
//        }
//        return memo[idx][cur];
//    }
}

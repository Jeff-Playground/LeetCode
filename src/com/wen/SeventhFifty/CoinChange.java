package com.wen.SeventhFifty;

import java.util.Arrays;

public class CoinChange {
    // DP, unbounded knapsack optimized to one dimensional array
    public int coinChange(int[] coins, int amount) {
        int l=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<=l; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1]<=j && dp[j-coins[i-1]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j], dp[j-coins[i-1]]+1);
                } else{
                    dp[j]=dp[j];
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

//    // DP, unbounded knapsack
//    public int coinChange(int[] coins, int amount) {
//        int l=coins.length;
//        int[][] dp=new int[l+1][amount+1];
//        for(int i=0; i<=l; i++){
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//            dp[i][0]=0;
//        }
//        for(int i=1; i<=l; i++){
//            for(int j=1; j<=amount; j++){
//                if(coins[i-1]<=j && dp[i][j-coins[i-1]]!=Integer.MAX_VALUE){
//                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
//                } else{
//                    dp[i][j]=dp[i-1][j];
//                }
//            }
//        }
//        return dp[l][amount]==Integer.MAX_VALUE?-1:dp[l][amount];
//    }

//    // DP, bounded knapsack optimized to one dimensional array
//    public int coinChange(int[] coins, int amount) {
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

//    // DP, bounded knapsack
//    public int coinChange(int[] coins, int amount) {
//        int l=coins.length;
//        int[][] dp=new int[l+1][amount+1];
//        for(int i=0; i<=l; i++){
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//            dp[i][0]=0;
//        }
//        for(int i=1; i<=l; i++){
//            for(int j=1; j<=amount; j++){
//                int max=j/coins[i-1];
//                for(int k=0; k<=max; k++){
//                    if(dp[i-1][j-k*coins[i-1]]!=Integer.MAX_VALUE){
//                        dp[i][j]=Math.min(dp[i][j], dp[i-1][j-k*coins[i-1]]+k);
//                    }
//                }
//            }
//        }
//        return dp[l][amount]==Integer.MAX_VALUE?-1:dp[l][amount];
//    }
}

package com.wen.EleventhFifty;

import java.util.Arrays;

public class CoinChange2 {
    // Here using unbounded knapsack is simpler and makes more sense, the bounded knapsack solutions are just for practice

//    // DP, bounded knapsack optimized to one dimensional array
//    public static int change(int amount, int[] coins) {
//        int l=coins.length;
//        int[] dp=new int[amount+1];
//        dp[0]=1;
//        for(int i=1; i<l+1; i++){
//            for(int j=amount; j>=0; j--){
//                if(coins[i-1]<=j){
//                    int max=j/coins[i-1];
//                    // Note here k starts with 1 because dp[j] already included the value for k=0
//                    for(int k=1; k<max+1; k++){
//                        dp[j]+=dp[j-k*coins[i-1]];
//                    }
//                } else{
//                    dp[j]=dp[j];
//                }
//            }
//        }
//        return dp[amount];
//    }

//    // DP, bounded knapsack
//    public int change(int amount, int[] coins) {
//        int l=coins.length;
//        int[][] dp=new int[l+1][amount+1];
//        dp[0][0]=1;
//        for(int i=1; i<l+1; i++){
//            for(int j=0; j<amount+1; j++){
//                if(coins[i-1]<=j){
//                    int max=j/coins[i-1];
//                    // Note here k starts with 0 because dp[i][j] starts with 0
//                    for(int k=0; k<max+1; k++){
//                        dp[i][j]+=dp[i-1][j-k*coins[i-1]];
//                    }
//                } else{
//                    dp[i][j]=dp[i-1][j];
//                }
//            }
//        }
//        return dp[l][amount];
//    }

//    // DP, bounded knapsack, top down
//    public int change(int amount, int[] coins) {
//        int l=coins.length;
//        int[][] memo=new int[l][amount+1];
//        for(int[] m: memo){
//            Arrays.fill(m, -1);
//        }
//        return dp(coins, l-1, amount, memo);
//    }
//
//    private int dp(int[] coins, int idx, int cur, int[][] memo){
//        if(memo[idx][cur]==-1){
//            if(cur==0){
//                memo[idx][cur]=1;
//            } else{
//                if(idx==0){
//                    memo[idx][cur]=cur%coins[0]==0?1:0;
//                } else{
//                    int max=cur/coins[idx];
//                    memo[idx][cur]=0;
//                    for(int i=0; i<=max; i++){
//                        memo[idx][cur]+=dp(coins, idx-1, cur-i*coins[idx], memo);
//                    }
//                }
//            }
//        }
//        return memo[idx][cur];
//    }

//    // DP, unbounded knapsack optimized to one dimensional array, as no iteration along 1 dimension - the dimension of
//    // coins idx
//    public int change(int amount, int[] coins) {
//        int l=coins.length;
//        int[] dp=new int[amount+1];
//        dp[0]=1;
//        for(int i=1; i<l+1; i++){
//            for(int j=0; j<amount+1; j++){
//                if(coins[i-1]<=j){
//                    dp[j]=dp[j]+dp[j-coins[i-1]];
//                } else{
//                    dp[j]=dp[j];
//                }
//            }
//        }
//        return dp[amount];
//    }

    // DP, unbounded knapsack
    public int change(int amount, int[] coins) {
        int l=coins.length;
        int[][] dp=new int[l+1][amount+1];
        dp[0][0]=1;
        for(int i=1; i<l+1; i++){
            for(int j=0; j<amount+1; j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                } else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[l][amount];
    }

//    // DP, unbounded knapsack, top down
//    public int change(int amount, int[] coins) {
//        int l=coins.length;
//        int[][] memo=new int[l][amount+1];
//        for(int[] m: memo){
//            Arrays.fill(m, -1);
//        }
//        return dp(coins, l-1, amount, memo);
//    }
//
//    private int dp(int[] coins, int idx, int cur, int[][] memo){
//        if(memo[idx][cur]==-1){
//            if(cur==0){
//                memo[idx][cur]=1;
//            } else{
//                if(idx==0){
//                    memo[idx][cur]=cur%coins[0]==0?1:0;
//                } else{
//                    if(coins[idx]<=cur){
//                        memo[idx][cur]=dp(coins, idx-1, cur, memo)+dp(coins, idx, cur-coins[idx], memo);
//                    } else{
//                        memo[idx][cur]=dp(coins, idx-1, cur, memo);
//                    }
//                }
//            }
//        }
//        return memo[idx][cur];
//    }
}

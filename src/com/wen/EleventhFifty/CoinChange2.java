package com.wen.EleventhFifty;

public class CoinChange2 {
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
//        for(int i=0; i<l+1; i++){
//            dp[i][0]=1;
//        }
//        for(int i=1; i<l+1; i++){
//            for(int j=1; j<amount+1; j++){
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

    // DP, unbounded knapsack optimized to one dimensional array
    public int change(int amount, int[] coins) {
        int l=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=1; i<l+1; i++){
            for(int j=0; j<amount+1; j++){
                if(coins[i-1]<=j){
                    dp[j]=dp[j]+dp[j-coins[i-1]];
                } else{
                    dp[j]=dp[j];
                }
            }
        }
        return dp[amount];
    }

//    // DP, unbounded knapsack
//    public int change(int amount, int[] coins) {
//        int l=coins.length;
//        int[][] dp=new int[l+1][amount+1];
//        for(int i=0; i<l+1; i++){
//            dp[i][0]=1;
//        }
//        for(int i=1; i<l+1; i++){
//            for(int j=1; j<amount+1; j++){
//                if(coins[i-1]<=j){
//                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
//                } else{
//                    dp[i][j]=dp[i-1][j];
//                }
//            }
//        }
//        return dp[l][amount];
//    }
}

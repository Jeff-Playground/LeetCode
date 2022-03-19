package com.wen.FourthFifty;

public class BestTimeToBuyAndSellStockIV {
//    // Use one dimensional array to save space
//    public int maxProfit(int k, int[] prices) {
//        if(k<=0) {
//            return 0;
//        }
//        int n=prices.length;
//        if(k>n/2) {
//            return maxProfitUnlimited(prices);
//        }
//        int local[]=new int[k+1], global[]=new int[k+1];
//        for(int i=1; i<n; i++) {
//            int diff=prices[i]-prices[i-1];
//            for(int j=k; j>0; j--) {
//                local[j]=Math.max(global[j-1]+Math.max(0, diff), local[j]+diff);
//                global[j]=Math.max(global[j], local[j]);
//            }
//        }
//        return global[k];
//    }

//    // Dynamic Programming
//    // local[i][j] stands for the maximum profit to complete the j-th trade on day i, global[i][j] stands for the
//    // maximum profit to complete the j-th trade on or before day i
//    public int maxProfit(int k, int[] prices) {
//        if(k<=0) {
//            return 0;
//        }
//        int n=prices.length;
//        if(k>n/2) {
//            return maxProfitUnlimited(prices);
//        }
//        int local[][]=new int[n][k+1], global[][]=new int[n][k+1];
//        for(int i=1; i<n; i++) {
//            int diff=prices[i]-prices[i-1];
//            for(int j=1; j<k+1; j++) {
//                local[i][j]=Math.max(global[i-1][j-1]+Math.max(0, diff), local[i-1][j]+diff);
//                global[i][j]=Math.max(global[i-1][j], local[i][j]);
//            }
//        }
//        return global[n-1][k];
//    }
//
//    public int maxProfitUnlimited(int[] prices) {
//        int result=0;
//        int n=prices.length;
//        for(int i=0; i<n-1; i++) {
//            if(prices[i+1]>prices[i]) {
//                result+=prices[i+1]-prices[i];
//            }
//        }
//        return result;
//    }

//    // DP2, bottom up
//    // dp[i][j][k] stands for the maximum profit on day i(0-indexed) when remain j transactions and holding(0/1) is k
//    public int maxProfit(int k, int[] prices) {
//        int l=prices.length;
//        if(k==0 || l<=1){
//            return 0;
//        }
//        int[][][] dp=new int[l][k+1][2];
//        for(int i=l-1; i>=0; i--){
//            for(int j=k; j>=0; j--){
//                if(i==l-1){
//                    dp[i][j][0]=0;
//                    dp[i][j][1]=j>0?prices[i]:0;
//                } else{
//                    if(j==0){
//                        dp[i][j][0]=dp[i][j][1]=0;
//                    } else{
//                        dp[i][j][0]=Math.max(dp[i+1][j][0], dp[i+1][j][1]-prices[i]);
//                        dp[i][j][1]=Math.max(dp[i+1][j][1], dp[i+1][j-1][0]+prices[i]);
//                    }
//                }
//            }
//        }
//        return dp[0][k][0];
//    }

//    // DP2, top down
//    public int maxProfit(int k, int[] prices) {
//        int l=prices.length;
//        if(k==0 || l<=1){
//            return 0;
//        }
//        int[][][] memo=new int[l][k+1][2];
//        return dp(prices, 0, k, 0, memo);
//    }
//
//    private int dp(int[] prices, int day, int transactions, int holding, int[][][] memo){
//        if(memo[day][transactions][holding]==0){
//            int l=prices.length;
//            if(transactions==0){
//                return 0;
//            } else{
//                if(holding==0){
//                    if(day==l-1){
//                        return 0;
//                    } else{
//                        memo[day][transactions][holding]=Math.max(dp(prices, day+1, transactions, 0, memo), dp(prices, day+1, transactions, 1, memo)-prices[day]);
//                    }
//                } else{
//                    if(day==l-1){
//                        memo[day][transactions][holding]=prices[day];
//                    } else{
//                        memo[day][transactions][holding]=Math.max(dp(prices, day+1, transactions, 1, memo), dp(prices, day+1, transactions-1, 0, memo)+prices[day]);
//                    }
//                }
//            }
//        }
//        return memo[day][transactions][holding];
//    }
}

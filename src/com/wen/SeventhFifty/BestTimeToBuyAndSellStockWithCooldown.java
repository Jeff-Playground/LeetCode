package com.wen.SeventhFifty;

public class BestTimeToBuyAndSellStockWithCooldown {
//    // Optimized DP, use variables instead of arrays
//    public static int maxProfit(int[] prices) {
//        if(prices==null || prices.length<2){
//            return 0;
//        }
//        int l=prices.length;
//        int preBuy=-prices[0], preSell=0;
//        int buy=Math.max(0-prices[1], preBuy), sell=Math.max(preBuy+prices[1], preSell);
//        for(int i=2; i<l; i++){
//            preBuy=buy;
//            buy=Math.max(preSell-prices[i], buy);
//            preSell=sell;
//            sell=Math.max(preBuy+prices[i], sell);
//        }
//        return sell;
//    }

//    // Optimized DP, based on:
//    // rest[i]==sell[i-1]
//    public int maxProfit(int[] prices) {
//        if(prices==null || prices.length<2){
//            return 0;
//        }
//        int l=prices.length;
//        int[] buy=new int[l], sell=new int[l];
//        buy[0]=-prices[0];
//        sell[0]=0;
//        for(int i=1; i<l; i++){
//            buy[i]=Math.max((i<2?0:sell[i-2])-prices[i], buy[i-1]);
//            sell[i]=Math.max(buy[i-1]+prices[i], sell[i-1]);
//        }
//        return sell[l-1];
//    }

    // DP, with detailed logic
    // buy[i] stands for the maxProfit where last buy is on day i, sell[i] stands for the maxProfit where last sell is on
    // day i, coolDown[i] stands for the maxProfit where last cooldown is on day i
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){
            return 0;
        }
        int l=prices.length;
        int[] buy=new int[l], sell=new int[l], coolDown=new int[l];
        buy[0]=-prices[0];
        int maxBuy=buy[0];
        for(int i=1; i<l; i++){
            buy[i]=coolDown[i-1]-prices[i];
            sell[i]=maxBuy+prices[i];
            coolDown[i]=Math.max(sell[i-1], coolDown[i-1]);
            maxBuy=Math.max(maxBuy, buy[i]);
        }
        return Math.max(sell[l-1], coolDown[l-1]);
    }

//    // DP3, bottom up
//    // dp[i][j] stands for the max profit for day i(0-indexed), where current holding(0/1) is j
//    public int maxProfit(int[] prices) {
//        int l=prices.length;
//        int[][] dp=new int[l][2];
//        for(int i=l-1; i>=0; i--){
//            if(i==l-1){
//                dp[i][0]=0;
//                dp[i][1]=prices[i];
//            } else{
//                dp[i][0]=Math.max(dp[i+1][0], dp[i+1][1]-prices[i]);
//                dp[i][1]=Math.max(dp[i+1][1], (i+2<l?dp[i+2][0]:0)+prices[i]);
//            }
//        }
//        return dp[0][0];
//    }

//    // DP3, top down
//    public int maxProfit(int[] prices) {
//        int l=prices.length;
//        int[][] memo=new int[l][2];
//        return dp(prices, 0, 0, memo);
//    }
//
//    private int dp(int[] prices, int day, int hold, int[][] memo){
//        if(memo[day][hold]==0){
//            int l=prices.length;
//            if(day==l-1){
//                memo[day][hold]=hold==0?0:prices[day];
//            } else{
//                if(hold==0){
//                    memo[day][hold]=Math.max(dp(prices, day+1, 0, memo), dp(prices, day+1, 1, memo)-prices[day]);
//                } else{
//                    memo[day][hold]=Math.max(dp(prices, day+1, 1, memo), (day+2<l?dp(prices, day+2, 0, memo):0)+prices[day]);
//                }
//            }
//        }
//        return memo[day][hold];
//    }
}

package com.wen.FifteenthFifty;

public class BestTimeToBuyAndSellStockWithTransactionFee {
//    // DP2
//    // buy[i] is the max to buy on day i; sell[i] is the max to sell on day i, which is dependent on maxBuy so far;
//    // pass[i] is the max to do nothing when last action is sell or pass(so buy won't be after another buy)
//    public int maxProfit(int[] prices, int fee) {
//        if(prices==null || prices.length<2){
//            return 0;
//        }
//        int l=prices.length;
//        int[] buy=new int[l], sell=new int[l], pass=new int[l];
//        buy[0]=-prices[0];
//        int maxBuy=buy[0];
//        for(int i=1; i<l; i++){
//            buy[i]=Math.max(sell[i-1], pass[i-1])-prices[i];
//            sell[i]=maxBuy+prices[i]-fee;
//            pass[i]=Math.max(sell[i-1], pass[i-1]);
//            maxBuy=Math.max(maxBuy, buy[i]);
//        }
//        return Math.max(sell[l-1], pass[l-1]);
//    }

    // DP1, bottom up
    public int maxProfit(int[] prices, int fee) {
        int l=prices.length;
        int[][] dp=new int[l][2];
        for(int i=l-1; i>=0; i--){
            if(i==l-1){
                dp[i][0]=0;
                dp[i][1]=prices[i]-fee;
            } else{
                dp[i][0]=Math.max(dp[i+1][0], dp[i+1][1]-prices[i]);
                dp[i][1]=Math.max(dp[i+1][1], dp[i+1][0]+prices[i]-fee);
            }
        }
        return dp[0][0];
    }

//    // DP1, top down
//    public int maxProfit(int[] prices, int fee) {
//        int l=prices.length;
//        int[][] memo=new int[l][2];
//        return dp(prices, fee, 0, 0, memo);
//    }
//
//    private int dp(int[] prices, int fee, int day, int hold, int[][] memo){
//        if(memo[day][hold]==0){
//            int l=prices.length;
//            if(day==l-1){
//                memo[day][hold]=hold==0?0:prices[day]-fee;
//            } else{
//                if(hold==0){
//                    memo[day][hold]=Math.max(dp(prices, fee, day+1, 0, memo), dp(prices, fee, day+1, 1, memo)-prices[day]);
//                } else{
//                    memo[day][hold]=Math.max(dp(prices, fee, day+1, 1, memo), dp(prices, fee, day+1, 0, memo)+prices[day]-fee);
//                }
//            }
//        }
//        return memo[day][hold];
//    }
}

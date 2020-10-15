package com.wen.FifteenthFifty;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    // buy[i] is the max to buy on day i; sell[i] is the max to sell on day i, which is dependent on maxBuy so far;
    // pass[i] is the max to do nothing when last action is sell or pass(so buy won't be after another buy)
    public int maxProfit(int[] prices, int fee) {
        if(prices==null || prices.length<2){
            return 0;
        }
        int l=prices.length;
        int[] buy=new int[l], sell=new int[l], pass=new int[l];
        buy[0]=-prices[0];
        int maxBuy=buy[0];
        for(int i=1; i<l; i++){
            buy[i]=Math.max(sell[i-1], pass[i-1])-prices[i];
            sell[i]=maxBuy+prices[i]-fee;
            pass[i]=Math.max(sell[i-1], pass[i-1]);
            maxBuy=Math.max(maxBuy, buy[i]);
        }
        return Math.max(sell[l-1], pass[l-1]);
    }
}

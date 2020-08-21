package com.wen.FifteenthFifty;

public class BestTimeToBuyAndSellStockWithTransactionFee {
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

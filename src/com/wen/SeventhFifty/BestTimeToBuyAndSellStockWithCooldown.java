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
}

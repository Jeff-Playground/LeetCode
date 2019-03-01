package com.wen.ThirdFifty;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int result=0;
        if(prices!=null && prices.length>0) {
            for(int i=0; i<prices.length-1; i++) {
                if(prices[i]<prices[i+1]) {
                    result+=prices[i+1]-prices[i];
                }
            }
        }
        return result;
    }
}

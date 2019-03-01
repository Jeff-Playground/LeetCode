package com.wen.ThirdFifty;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int low=Integer.MAX_VALUE, result=Integer.MIN_VALUE;
        for(int price: prices) {
            low=low>price?price:low;
            result=result>(price-low)?result:price-low;
        }
        return result;
    }
}

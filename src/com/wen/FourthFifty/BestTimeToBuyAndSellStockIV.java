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

    public int maxProfit(int k, int[] prices) {
        if(k<=0) {
            return 0;
        }
        int n=prices.length;
        if(k>n/2) {
            return maxProfitUnlimited(prices);
        }
        int local[][]=new int[n][k+1], global[][]=new int[n][k+1];
        for(int i=1; i<n; i++) {
            int diff=prices[i]-prices[i-1];
            for(int j=1; j<k+1; j++) {
                local[i][j]=Math.max(global[i-1][j-1]+Math.max(0, diff), local[i-1][j]+diff);
                global[i][j]=Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[n-1][k];
    }

    public int maxProfitUnlimited(int[] prices) {
        int result=0;
        int n=prices.length;
        for(int i=0; i<n-1; i++) {
            if(prices[i+1]>prices[i]) {
                result+=prices[i+1]-prices[i];
            }
        }
        return result;
    }
}

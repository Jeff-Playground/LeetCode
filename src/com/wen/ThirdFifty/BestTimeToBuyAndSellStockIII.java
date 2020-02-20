package com.wen.ThirdFifty;

public class BestTimeToBuyAndSellStockIII {
//    // Optimized Dynamic Programming
//    public static int maxProfit(int[] prices) {
//        if(prices==null || prices.length==0){
//            return 0;
//        }
//        int n=prices.length;
//        int[] local=new int[3], global=new int[3];
//        for(int i=1; i<n; i++){
//            int diff=prices[i]-prices[i-1];
//            for(int j=2; j>0; j--){
//                local[j]=Math.max(global[j-1]+Math.max(0, diff), local[j]+diff);
//                global[j]=Math.max(global[j], local[j]);
//            }
//        }
//        return global[2];
//    }

    // Dynamic Programming
    // local[i][j] stands for the maximum profit to complete the j-th trade on day i, global[i][j] stands for the
    // maximum profit to complete the j-th trade on or before day i
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int n=prices.length;
        int[][] local=new int[n][3], global=new int[n][3];
        for(int i=1; i<n; i++){
            int diff=prices[i]-prices[i-1];
            for(int j=1; j<3; j++){
                local[i][j]=Math.max(global[i-1][j-1]+Math.max(0, diff), local[i-1][j]+diff);
                global[i][j]=Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[n-1][2];
    }
}

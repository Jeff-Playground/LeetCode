package com.wen.SixthFifty;

public class LQPaintHouseII {
    // DP, optimized to get rid of dp array
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0){
            return 0;
        }
        int n=costs.length, k=costs[0].length;
        int preMin1=-1, preMin2=-1, preMinColor1=-1;
        for(int i=0; i<n; i++){
            int curMin1=Integer.MAX_VALUE, curMin2=Integer.MAX_VALUE, curMinColor1=-1;
            int cost=-1;
            for(int j=0; j<k; j++){
                if(i==0){
                    cost=costs[i][j];
                } else{
                    if(j==preMinColor1){
                        cost=costs[i][j]+preMin2;
                    } else{
                        cost=costs[i][j]+preMin1;
                    }
                }
                if(cost<curMin1){
                    curMin2=curMin1;
                    curMin1=cost;
                    curMinColor1=j;
                } else if(cost<curMin2){
                    curMin2=cost;
                }
            }
            preMin1=curMin1;
            preMin2=curMin2;
            preMinColor1=curMinColor1;
        }
        return preMin1;
    }

//    // DP
//    public int minCostII(int[][] costs) {
//        if(costs==null || costs.length==0 || costs[0].length==0){
//            return 0;
//        }
//        int n=costs.length, k=costs[0].length;
//        int[][] dp=new int[n][k];
//        int preMinColor1=-1, preMinColor2=-1;
//        for(int i=0; i<n; i++){
//            int curMinColor1=-1, curMinColor2=-1;
//            for(int j=0; j<k; j++){
//                if(i==0){
//                    dp[i][j]=costs[i][j];
//                } else{
//                    if(j==preMinColor1){
//                        dp[i][j]=costs[i][j]+dp[i-1][preMinColor2];
//                    } else{
//                        dp[i][j]=costs[i][j]+dp[i-1][preMinColor1];
//                    }
//                }
//                if(curMinColor1==-1 || dp[i][j]<dp[i][curMinColor1]){
//                    curMinColor2=curMinColor1;
//                    curMinColor1=j;
//                } else if(curMinColor2==-1 || dp[i][j]<dp[i][curMinColor2]){
//                    curMinColor2=j;
//                }
//            }
//            preMinColor1=curMinColor1;
//            preMinColor2=curMinColor2;
//        }
//        return dp[n-1][preMinColor1];
//    }
}

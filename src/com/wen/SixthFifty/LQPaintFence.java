package com.wen.SixthFifty;

public class LQPaintFence {
    // Optimized dp with no array
    public int numWays(int n, int k) {
        int[][] dp=new int[n][2];
        int preDiff=k, preSame=0;
        for(int i=1; i<n; i++){
            int curDiff=(preDiff+preSame)*(k-1);
            int curSame=preDiff;
            preDiff=curDiff;
            preSame=curSame;
        }
        return preDiff+preSame;
    }

//    // DP
//    public int numWays(int n, int k) {
//        int[][] dp=new int[n][2];
//        for(int i=0; i<n; i++){
//            if(i==0){
//                dp[i][0]=k;
//                dp[i][1]=0;
//            } else{
//                dp[i][0]=(dp[i-1][0]+dp[i-1][1])*(k-1);
//                dp[i][1]=dp[i-1][0];
//            }
//        }
//        return dp[n-1][0]+dp[n-1][1];
//    }
}

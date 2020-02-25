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
//    // dp[i][0] stands for the number of ways to paint the post at i to a color different than the previous post,
//    // dp[i][1] stands for the number of ways to paint the post at i to a color same with the previous post
//    public int numWays(int n, int k) {
//        int[][] dp=new int[n][2];
//        for(int i=0; i<n; i++){
//            if(i==0){
//                dp[i][0]=k;
//                dp[i][1]=0;
//            } else{
//                // For a different color, it's the total number of previous ways multiply by (k-1) because current color
//                // can be whichever color except the previous ONE
//                dp[i][0]=(dp[i-1][0]+dp[i-1][1])*(k-1);
//                // For a same color, the previous color can't be the same with the color before it, and it's the same
//                // ONE color
//                dp[i][1]=dp[i-1][0];
//            }
//        }
//        return dp[n-1][0]+dp[n-1][1];
//    }
}

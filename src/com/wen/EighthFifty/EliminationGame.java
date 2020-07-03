package com.wen.EighthFifty;

public class EliminationGame {
    // Similar to DP but recursive
    public int lastRemaining(int n) {
        if(n==1){
            return 1;
        }
        if(n%2==0){
            return n-1-2*(lastRemaining(n/2)-1)+1;
        } else{
            return n-2-2*(lastRemaining(n/2)-1)+1;
        }
    }

//    // DP, dp[i] stands for the result index when length is i, will MLEOK<
//    public int lastRemaining(int n) {
//        int[] dp=new int[n+1];
//        dp[1]=0;
//        for(int i=2; i<=n; i++){
//            if(i%2==0){
//                dp[i]=i-1-2*dp[i/2];
//            } else{
//                dp[i]=i-2-2*dp[i/2];
//            }
//        }
//        return dp[n]+1;
//    }
}

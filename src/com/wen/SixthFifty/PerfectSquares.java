package com.wen.SixthFifty;

import java.util.Arrays;

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, n);
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<n+1; i++){
            for(int j=1; i-j*j>=0; j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}

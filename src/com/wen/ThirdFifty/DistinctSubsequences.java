package com.wen.ThirdFifty;

import java.util.Arrays;

public class DistinctSubsequences {
    // DP
    // dp[i][j] stands for the number of distinct subsequences of t.substring(0, j+1) in s.substring(0, i+1)
    public int numDistinct(String s, String t) {
        int m=s.length(), n=t.length();
        if(m<n) {
            return 0;
        }
        int dp[][]=new int[m+1][n+1];
        for(int i=0; i<m+1; i++) {
            Arrays.fill(dp[i], 0);
        }
        for(int i=0; i<m+1; i++) {
            dp[i][0]=1;
        }
        for(int j=1; j<n+1; j++) {
            for(int i=1; i<m+1; i++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    // it's the sum of using s.charAt(i-1) as the last match and NOT using it as the last match
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}

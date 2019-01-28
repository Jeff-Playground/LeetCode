package com.wen.ThirdFifty;

import java.util.Arrays;

public class DistinctSubsequences {
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
            int last=-1;
            for(int i=j; i<m+1; i++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    if(last==-1) {
                        dp[i][j]=dp[i-1][j-1];
                    } else {
                        dp[i][j]=dp[i-1][j-1]+dp[last][j];
                    }
                    last=i;
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}

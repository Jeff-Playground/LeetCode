package com.wen.SecondFifty;

import java.util.Arrays;

public class UniquePaths {
    // Dynamic Programming with one-dimensional array
    public int uniquePaths(int m, int n) {
        int dp[]=new int[n];
        Arrays.fill(dp, 0);
        for(int i=0; i<=m-1; i++) {
            for(int j=0; j<=n-1; j++) {
                if(j>0) {
                    dp[j]+=dp[j-1];
                } else {
                    dp[j]=1;
                }
            }
        }
        return dp[n-1];
    }

//    // Dynamic Programming with two-dimensional array
//    public int uniquePaths(int m, int n) {
//        int dp[][]=new int[m][n];
//        for(int i=0; i<=m-1; i++) {
//            for(int j=0; j<=n-1; j++) {
//                if(i==0 || j==0) {
//                    dp[i][j]=1;
//                } else {
//                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
//                }
//            }
//        }
//        return dp[m-1][n-1];
//    }

//    // Permutation formula
//    public int uniquePaths(int m, int n) {
//        if(m<n) {
//            return uniquePaths(n, m);
//        }
//        long dividend=1, divisor=1;
//        for(int i=1; i<n; i++) {
//            dividend*=m+n-1-i;
//            divisor*=i;
//        }
//        return (int) (dividend/divisor);
//    }
}

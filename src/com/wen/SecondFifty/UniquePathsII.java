package com.wen.SecondFifty;

import java.util.Arrays;

public class UniquePathsII {
    // Dynamic Programming with one-dimensional array
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int dp[]=new int[n];
        Arrays.fill(dp, 0);
        dp[0]=1;
        for(int i=0; i<=m-1; i++) {
            for(int j=0; j<=n-1; j++) {
                if(obstacleGrid[i][j]==1) {
                    if(i==0 && j==0) {
                        return 0;
                    }
                    dp[j]=0;
                } else {
                    if(j>0) {
                        dp[j]+=dp[j-1];
                    }
                }
            }
        }
        return dp[n-1];
    }

//    // Dynamic Programming with two-dimensional array
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m=obstacleGrid.length, n=obstacleGrid[0].length;
//        int dp[][]=new int[m][n];
//        for(int i=0; i<=m-1; i++) {
//            for(int j=0; j<=n-1; j++) {
//                if(obstacleGrid[i][j]==1) {
//                    dp[i][j]=0;
//                } else {
//                    if(i==0) {
//                        if(j==0) {
//                            dp[i][j]=1;
//                        } else {
//                            dp[i][j]=dp[i][j-1];
//                        }
//                    } else if(j==0) {
//                        dp[i][j]=dp[i-1][j];
//                    } else {
//                        dp[i][j]=dp[i-1][j]+dp[i][j-1];
//                    }
//                }
//            }
//        }
//        return dp[m-1][n-1];
//    }
}

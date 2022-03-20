package com.wen.SecondFifty;

public class MinimumPathSum {
//    // Dynamic Programming, bottom up
//    // dp[i][j] stands for the minimum sum to reach node (i, j)
//    public static int minPathSum(int[][] grid) {
//        if(grid==null || grid.length==0){
//            return 0;
//        }
//        int m=grid.length, n=grid[0].length;
//        int[][] dp=new int[m][n];
//        dp[0][0]=grid[0][0];
//        for(int i=1; i<n; i++){
//            dp[0][i]=dp[0][i-1]+grid[0][i];
//        }
//        for(int i=1; i<m; i++){
//            dp[i][0]=dp[i-1][0]+grid[i][0];
//        }
//        for(int i=1; i<m; i++){
//            for(int j=1; j<n; j++){
//                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
//            }
//        }
//        return dp[m-1][n-1];
//    }

    // DP, top down
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int memo[][]=new int[m][n];
        return dp(grid, m-1, n-1, memo);
    }

    private int dp(int[][] grid, int i, int j, int[][] memo){
        if(memo[i][j]==0){
            if(i==0 && j==0){
                memo[i][j]=grid[i][j];
            } else if(i==0){
                memo[i][j]=grid[i][j]+dp(grid, i, j-1, memo);
            } else if(j==0){
                memo[i][j]=grid[i][j]+dp(grid, i-1, j, memo);
            } else{
                memo[i][j]=grid[i][j]+Math.min(dp(grid, i, j-1, memo), dp(grid, i-1, j, memo));
            }
        }
        return memo[i][j];
    }
}

package com.wen.NineteenthFifty;

public class MinimumFallingPathSum {
//    // DP, bottom up
//    public int minFallingPathSum(int[][] A) {
//        int m=A.length, n=A[0].length;
//        int[][] dp=new int[m][n];
//        int result=Integer.MAX_VALUE;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(i==0){
//                    dp[i][j]=A[i][j];
//                    if(i==m-1){
//                        result=Math.min(result, dp[i][j]);
//                    }
//                } else{
//                    int aboveMin=Integer.MAX_VALUE;
//                    if(j>0){
//                        aboveMin=Math.min(aboveMin, dp[i-1][j-1]);
//                    }
//                    aboveMin=Math.min(aboveMin, dp[i-1][j]);
//                    if(j<n-1){
//                        aboveMin=Math.min(aboveMin, dp[i-1][j+1]);
//                    }
//                    dp[i][j]=A[i][j]+aboveMin;
//                    if(i==m-1){
//                        result=Math.min(result, dp[i][j]);
//                    }
//                }
//            }
//        }
//        return result;
//    }

    // DP, top down
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] memo=new int[m][n];
        int result=Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            result=Math.min(result, dp(matrix, m-1, j, memo));
        }
        return result;
    }

    private int dp(int[][] matrix, int i, int j, int[][] memo){
        if(memo[i][j]==0){
            if(i==0){
                memo[i][j]=matrix[i][j];
            } else{
                int min=Integer.MAX_VALUE;
                if(j-1>=0){
                    min=Math.min(min, dp(matrix, i-1, j-1, memo));
                }
                min=Math.min(min, dp(matrix, i-1, j, memo));
                if(j+1<memo[0].length){
                    min=Math.min(min, dp(matrix, i-1, j+1, memo));
                }
                memo[i][j]=min+matrix[i][j];
            }
        }
        return memo[i][j];
    }
}

package com.wen.NineteenthFifty;

public class MinimumFallingPathSum {
    // DPMinimum Falling Path Sum II
    public int minFallingPathSum(int[][] A) {
        int m=A.length, n=A[0].length;
        int[][] dp=new int[m][n];
        int result=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    dp[i][j]=A[i][j];
                    if(i==m-1){
                        result=Math.min(result, dp[i][j]);
                    }
                } else{
                    int aboveMin=Integer.MAX_VALUE;
                    if(j>0){
                        aboveMin=Math.min(aboveMin, dp[i-1][j-1]);
                    }
                    aboveMin=Math.min(aboveMin, dp[i-1][j]);
                    if(j<n-1){
                        aboveMin=Math.min(aboveMin, dp[i-1][j+1]);
                    }
                    dp[i][j]=A[i][j]+aboveMin;
                    if(i==m-1){
                        result=Math.min(result, dp[i][j]);
                    }
                }
            }
        }
        return result;
    }
}

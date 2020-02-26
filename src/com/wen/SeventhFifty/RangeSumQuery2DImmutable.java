package com.wen.SeventhFifty;

public class RangeSumQuery2DImmutable {
    // dp[i][j] stands for the sum of all numbers nums[x][y] where x<=i and y<=j
    class NumMatrix {
        int[][] dp=null;

        public NumMatrix(int[][] matrix) {
            if(matrix==null || matrix.length==0 || matrix[0].length==0){
                dp=new int[][]{{}};
            } else{
                int m=matrix.length, n=matrix[0].length;
                dp=new int[m][n];
                for(int i=0; i<m; i++){
                    for(int j=0; j<n; j++){
                        dp[i][j]=matrix[i][j];
                        int count=0;
                        if(i>0){
                            dp[i][j]+=dp[i-1][j];
                            count++;
                        }
                        if(j>0){
                            dp[i][j]+=dp[i][j-1];
                            count++;
                        }
                        if(count>1){
                            dp[i][j]-=dp[i-1][j-1];
                        }
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(row1>0 && col1>0){
                return dp[row2][col2]-dp[row1-1][col2]-dp[row2][col1-1]+dp[row1-1][col1-1];
            } else if(row1==0 && col1>0){
                return dp[row2][col2]-dp[row2][col1-1];
            } else if(row1>0 && col1==0){
                return dp[row2][col2]-dp[row1-1][col2];
            } else {
                return dp[row2][col2];
            }
        }
    }
}

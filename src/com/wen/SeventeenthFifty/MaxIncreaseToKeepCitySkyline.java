package com.wen.SeventeenthFifty;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[] rowMax=new int[m], colMax=new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rowMax[i]=Math.max(rowMax[i], grid[i][j]);
                colMax[j]=Math.max(colMax[j], grid[i][j]);
            }
        }
        int result=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result+=Math.min(rowMax[i], colMax[j])-grid[i][j];
            }
        }
        return result;
    }
}

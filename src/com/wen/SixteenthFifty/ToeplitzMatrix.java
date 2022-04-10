package com.wen.SixteenthFifty;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int m=matrix.length, n=matrix[0].length;
        if(m==1){
            return true;
        }
        // This is basically only comparing 2 rows for each while iteration, and ensure matrix[lastRow][jIdx]==matrix[curRow][jIdx+1]
        int lastRow=0, curRow=1;
        while(curRow<m){
            for(int j=0; j<n-1; j++){
                if(matrix[lastRow][j]!=matrix[curRow][j+1]){
                    return false;
                }
            }
            lastRow++;
            curRow++;
        }
        return true;
    }
}

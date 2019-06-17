package com.wen.FifthFifty;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int m=matrix.length, n=matrix[0].length;
        int i=m-1, j=0;
        while(i>=0 && j<=n-1 && matrix[i][j]!=target){
            if(matrix[i][j]<target){
                j++;
            } else{
                i--;
            }
        }
        return i!=-1 && j!=n;
    }
}

package com.wen.SecondFifty;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return;
        }
        int m=matrix.length, n=matrix[0].length;
        int[] hor=new int[m];
        int[] ver=new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    hor[i]=1;
                    ver[j]=1;
                }
            }
        }
        for(int i=0; i<m; i++){
            if(hor[i]==1){
                for(int j=0; j<n; j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0; j<n; j++){
            if(ver[j]==1){
                for(int i=0; i<m; i++){
                    matrix[i][j]=0;
                }
            }
        }
        return;
    }
}

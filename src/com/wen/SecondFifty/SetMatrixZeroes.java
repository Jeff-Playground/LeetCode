package com.wen.SecondFifty;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return;
        }
        int m=matrix.length, n=matrix[0].length;
        boolean firstRowZero=false, firstColumnZero=false;
        for(int i=0; i<m; i++){
            if(matrix[i][0]==0){
                firstColumnZero=true;
                break;
            }
        }
        for(int j=0; j<n; j++){
            if(matrix[0][j]==0){
                firstRowZero=true;
                break;
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowZero){
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }
        if(firstColumnZero){
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
        return;
    }

//    // O(m+n) space
//    public void setZeroes(int[][] matrix) {
//        if(matrix==null || matrix.length==0 || matrix[0].length==0){
//            return;
//        }
//        int m=matrix.length, n=matrix[0].length;
//        int[] hor=new int[m];
//        int[] ver=new int[n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j]==0){
//                    hor[i]=1;
//                    ver[j]=1;
//                }
//            }
//        }
//        for(int i=0; i<m; i++){
//            if(hor[i]==1){
//                for(int j=0; j<n; j++){
//                    matrix[i][j]=0;
//                }
//            }
//        }
//        for(int j=0; j<n; j++){
//            if(ver[j]==1){
//                for(int i=0; i<m; i++){
//                    matrix[i][j]=0;
//                }
//            }
//        }
//        return;
//    }
}

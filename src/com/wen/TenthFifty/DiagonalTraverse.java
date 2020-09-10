package com.wen.TenthFifty;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return new int[]{};
        }
        boolean up=true;
        int m=matrix.length, n=matrix[0].length;
        int idx=0;
        int[] result=new int[m*n];
        for(int count=0; count<m*n; count++){
            if(up){
                int[] start=new int[2];
                if(count<m){
                    start[0]=count;
                    start[1]=0;
                } else{
                    start[0]=m-1;
                    start[1]=count-m+1;
                }
                for(int i=start[0], j=start[1]; i>=0 && j<n; i--, j++){
                    result[idx++]=matrix[i][j];
                }
            } else{
                int[] start=new int[2];
                if(count<n){
                    start[0]=0;
                    start[1]=count;
                } else{
                    start[0]=count-n+1;
                    start[1]=n-1;
                }
                for(int i=start[0], j=start[1]; i<m && j>=0; i++, j--){
                    result[idx++]=matrix[i][j];
                }
            }
            up=!up;
        }
        return result;
    }
}

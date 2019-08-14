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
        int last=0, cur=1;
        while(cur<m){
            for(int i=0; i<n-1; i++){
                if(matrix[last][i]!=matrix[cur][i+1]){
                    return false;
                }
            }
            last++;
            cur++;
        }
        return true;
    }
}

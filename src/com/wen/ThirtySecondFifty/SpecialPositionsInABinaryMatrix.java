package com.wen.ThirtySecondFifty;

public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        if(mat==null || mat.length==0 || mat[0].length==0){
            return 0;
        } else{
            int m=mat.length, n=mat[0].length;
            int[] row=new int[m], col=new int[n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(mat[i][j]==1){
                        row[i]++;
                        col[j]++;
                    }
                }
            }
            int result=0;
            for(int i=0; i<m; i++){
                if(row[i]==1){
                    for(int j=0; j<n; j++){
                        if(mat[i][j]==1){
                            if(col[j]==1){
                                result++;
                            }
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
}

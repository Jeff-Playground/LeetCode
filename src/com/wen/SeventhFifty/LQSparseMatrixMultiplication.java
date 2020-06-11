package com.wen.SeventhFifty;

public class LQSparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRow=A.length, aCol=A[0].length, bRow=B.length, bCol=B[0].length;
        int[][] result=new int[aRow][bCol];
        for(int i=0; i<aRow; i++){
            for(int j=0; j<aCol; j++){
                if(A[i][j]!=0){
                    for(int k=0; k<bCol; k++){
                        if(B[j][k]!=0){
                            result[i][k]+=A[i][j]*B[j][k];
                        }
                    }
                }
            }
        }
        return result;
    }
}

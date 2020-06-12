package com.wen.SeventhFifty;

/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */

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

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

import java.util.HashMap;
import java.util.Map;

public class LQSparseMatrixMultiplication {
//    public int[][] multiply(int[][] mat1, int[][] mat2) {
//        int r=mat1.length, m=mat1[0].length, c=mat2[0].length;
//        int[][] result=new int[r][c];
//        for(int i=0; i<r; i++){
//            for(int j=0; j<m; j++){
//                if(mat1[i][j]!=0){
//                    for(int k=0; k<c; k++){
//                        if(mat2[j][k]!=0){
//                            result[i][k]+=mat1[i][j]*mat2[j][k];
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int r=mat1.length, m=mat1[0].length, c=mat2[0].length;
        int[][] result=new int[r][c];
        Map<Integer, Map<Integer, Integer>> map=new HashMap<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<m; j++){
                map.putIfAbsent(j, new HashMap<>());
                if(mat1[i][j]!=0){
                    map.get(j).put(i,mat1[i][j]);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<c; j++){
                if(mat2[i][j]!=0){
                    for(int k: map.get(i).keySet()){
                        result[k][j]+=mat2[i][j]*map.get(i).get(k);
                    }
                }
            }
        }
        return result;
    }
}

package com.wen.TenthFifty;

import java.util.List;
import java.util.TreeMap;

public class DiagonalTraverse {
//    public int[] findDiagonalOrder(int[][] matrix) {
//        if(matrix==null || matrix.length==0 || matrix[0].length==0){
//            return new int[]{};
//        }
//        int m=matrix.length, n=matrix[0].length;
//        TreeMap<Integer, List<Integer>> org=new TreeMap<>();
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                org.putIfAbsent(i+j, new ArrayList<>());
//                if((i+j)%2==1){
//                    org.get(i+j).add(matrix[i][j]);
//                } else{
//                    org.get(i+j).add(0, matrix[i][j]);
//                }
//            }
//        }
//        int[] result=new int[m*n];
//        int idx=0;
//        for(int key: org.keySet()){
//            for(int num: org.get(key)){
//                result[idx++]=num;
//            }
//        }
//        return result;
//    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int[] result=new int[m*n];
        int idx=0;
        for(int k=0; k<=m+n-2; k++){
            if(k%2==0){
                for(int j=k-Math.min(m-1, k); j<n && j<=k; j++){
                    result[idx++]=mat[k-j][j];
                }
            } else{
                for(int i=k-Math.min(n-1, k); i<m && i<=k; i++){
                    result[idx++]=mat[i][k-i];
                }
            }
        }
        return result;
    }
}

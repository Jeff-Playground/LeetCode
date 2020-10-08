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

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return new int[]{};
        }
        int m=matrix.length, n=matrix[0].length;
        int idx=0;
        int[] result=new int[m*n];
        // Here count is the number of lines processed
        for(int count=0; count<m+n; count++){
            int[] start=new int[2];
            if(count%2==0){
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
        }
        return result;
    }
}

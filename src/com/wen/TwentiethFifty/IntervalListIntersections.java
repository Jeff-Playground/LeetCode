package com.wen.TwentiethFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m=A.length, n=B.length;
        int i=0, j=0;
        List<int[]> result=new ArrayList<>();
        while(i<m && j<n){
            int[] temp=new int[4];
            temp[0]=A[i][0];
            temp[1]=A[i][1];
            temp[2]=B[j][0];
            temp[3]=B[j][1];
            Arrays.sort(temp);
            if(temp[1]==temp[2] || (temp[2]!=B[j][0] && temp[1]!=B[j][1])){
                result.add(new int[]{temp[1], temp[2]});
            }
            if(A[i][1]<B[j][1]){
                i++;
            } else if(A[i][1]>B[j][1]){
                j++;
            } else{
                i++;
                j++;
            }
        }
        int[][] r=new int[result.size()][2];
        for(int k=0; k<result.size(); k++){
            r[k]=result.get(k);
        }
        return r;
    }

//    public int[][] intervalIntersection(int[][] A, int[][] B) {
//        int m=A.length, n=B.length;
//        int i=0, j=0;
//        List<int[]> result=new ArrayList<>();
//        while(i<m && j<n){
//            int left=Math.max(A[i][0], B[j][0]), right=Math.min(A[i][1], B[j][1]);
//            if(left<=right){
//                result.add(new int[]{left, right});
//            }
//            if(A[i][1]<B[j][1]){
//                i++;
//            } else if(A[i][1]>B[j][1]){
//                j++;
//            } else{
//                i++;
//                j++;
//            }
//        }
//        int[][] r=new int[result.size()][2];
//        for(int k=0; k<result.size(); k++){
//            r[k]=result.get(k);
//        }
//        return r;
//    }
}

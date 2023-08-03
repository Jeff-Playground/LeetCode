package com.wen.FourteenthFifty;

import java.util.Arrays;

public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        int l=intervals.length, result=0;
        Arrays.sort(intervals, (a, b)->a[1]!=b[1]?a[1]-b[1]:b[0]-a[0]);
        int[] last=new int[]{-1,-1};
        for(int i=0; i<l; i++){
            int[] cur=intervals[i];
            if(i==0){
                result+=2;
                last[1]=cur[1];
                last[0]=cur[1]-1;
            } else{
                if(cur[0]<=last[0]){
                    continue;
                }
                if(cur[0]>last[1]){
                    result+=2;
                    last[1]=cur[1];
                    last[0]=cur[1]-1;
                } else{
                    result+=1;
                    last[0]=last[1];
                    last[1]=cur[1];
                }
            }
        }
        return result;
    }
}

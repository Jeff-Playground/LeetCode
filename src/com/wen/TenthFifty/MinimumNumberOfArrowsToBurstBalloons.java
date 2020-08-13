package com.wen.TenthFifty;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0){
            return 0;
        }
        int result=0, l=points.length;
        Arrays.sort(points, (a, b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int[] range=new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int i=0;
        while(i<l){
            int[] cur=points[i];
            while(!(cur[1]<range[0] || cur[0]>range[1])){
                range[0]=Math.max(range[0], cur[0]);
                range[1]=Math.min(range[1], cur[1]);
                if(++i<l){
                    cur=points[i];
                } else{
                    break;
                }
            }
            range=cur;
            result++;
        }
        return result;
    }
}

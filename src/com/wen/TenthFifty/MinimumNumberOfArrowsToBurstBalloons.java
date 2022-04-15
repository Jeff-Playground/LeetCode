package com.wen.TenthFifty;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
//    public int findMinArrowShots(int[][] points) {
//        int result=0;
//        // In comparison didn't use a[1]-b[1] as Integer.MIN_VALUE-Integer.MAX_VALUE will overflow from the tests
//        Arrays.sort(points, (a, b)->a[1]<b[1]?-1:1);
//        int p=points[0][1];
//        result++;
//        for(int i=1; i<points.length; i++){
//            int[] cur=points[i];
//            if(cur[0]>p){
//                p=cur[1];
//                result++;
//            }
//        }
//        return result;
//    }

    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0){
            return 0;
        }
        int result=1, l=points.length;
        Arrays.sort(points, (a, b)->a[0]<b[0]?-1:1);
        int[] shootingRange=new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        for(int i=0; i<l; i++){
            int[] cur=points[i];
            if(cur[0]>shootingRange[1]){
                shootingRange=cur;
                result++;
            } else{
                shootingRange[0]=Math.max(shootingRange[0], cur[0]);
                shootingRange[1]=Math.min(shootingRange[1], cur[1]);
            }
        }
        return result;
    }
}

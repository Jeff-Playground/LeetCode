package com.wen.TwentyFifthFifty;

import java.util.*;

public class MaximumProfitInJobScheduling {
//    // DP, bottom up, dp[i] stands for the maximum profit at time i
//    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//        int l=startTime.length;
//        if(l==1){
//            return profit[0];
//        }
//        int[][] tasks=new int[l][3];
//        for(int i=0; i<l; i++){
//            tasks[i][0]=startTime[i];
//            tasks[i][1]=endTime[i];
//            tasks[i][2]=profit[i];
//        }
//        Arrays.sort(tasks, (a, b)->a[1]-b[1]);
//        TreeMap<Integer, Integer> dp=new TreeMap<>();
//        dp.put(0,0);
//        for(int i=0; i<l; i++){
//            int[] cur=tasks[i];
//            dp.put(cur[1], Math.max(dp.get(dp.floorKey(cur[1])), dp.get(dp.floorKey(cur[0]))+cur[2]));
//        }
//        return dp.lastEntry().getValue();
//    }
}

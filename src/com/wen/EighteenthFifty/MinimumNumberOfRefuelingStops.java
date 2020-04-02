package com.wen.EighteenthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumNumberOfRefuelingStops {
//    // DP, dp[i] stands for the maximum length when stopping i times
//    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
//        if(startFuel>=target){
//            return 0;
//        }
//        int l=stations.length;
//        Arrays.sort(stations, (a, b)->a[0]-b[0]);
//        int[] dp=new int[l+1];
//        Set<Integer> stopped=new HashSet<>();
//        Arrays.fill(dp, startFuel);
//        for(int i=1; i<=l; i++){
//            int cur=dp[i-1], newStop=-1;
//            for(int j=0; j<l && stations[j][0]<=cur; j++){
//                if(!stopped.contains(j)){
//                    if(cur+stations[j][1]>dp[i]){
//                        dp[i]=cur+stations[j][1];
//                        newStop=j;
//                    }
//                }
//            }
//            if(dp[i]>=target){
//                return i;
//            }
//            stopped.add(newStop);
//        }
//        return -1;
//    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target){
            return 0;
        }
        int l=stations.length;
        int cur=startFuel, nextStation=0, stop=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[1]-a[1]);
        while(cur<target){
            if((nextStation==l || stations[nextStation][0]>cur) && pq.isEmpty()){
                return -1;
            }
            int i=nextStation;
            for(; i<l && stations[i][0]<=cur; i++){
                pq.offer(stations[i]);
            }
            nextStation=i;
            if(!pq.isEmpty()){
                cur+=pq.poll()[1];
                stop++;
            }
        }
        return stop;
    }
}

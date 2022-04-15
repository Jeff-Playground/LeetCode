package com.wen.NinthFifty;

import java.util.Arrays;

public class NonOverlappingIntervals {
    // Greedy, sort by start first then end
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length<=1){
            return 0;
        }
        int l=intervals.length;
        Arrays.sort(intervals, (a, b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        // last stores the end of the last interval added to non-overlapping set
        int total=1, last=intervals[0][1];
        for(int i=1; i<l; i++){
            if(intervals[i][0]>=last){  // not overlapping with previous last interval, add to set
                total++;
                last=intervals[i][1];
            } else{     // overlapping with previous last interval, keep only the one ends earlier
                last=Math.min(last, intervals[i][1]);
            }
        }
        return l-total;
    }

//    // Greedy, sort by end first then start
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if(intervals==null || intervals.length<=1){
//            return 0;
//        }
//        int l=intervals.length;
//        Arrays.sort(intervals, (a, b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
//        int total=1, last=intervals[0][1];
//        for(int i=1; i<l; i++){
//            // only keep the ones ends earlier when overlapping
//            if(intervals[i][0]>=last){
//                total++;
//                last=intervals[i][1];
//            }
//        }
//        return l-total;
//    }
}

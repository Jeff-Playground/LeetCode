package com.wen.NinthFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRightInterval {
    public static int[] findRightInterval(int[][] intervals) {
        if(intervals==null || intervals.length==0){
            return new int[0];
        }
        int l=intervals.length;
        Map<List<Integer>, Integer> idx=new HashMap<>();
        for(int i=0; i<l; i++){
            List<Integer> key= Arrays.asList(intervals[i][0], intervals[i][1]);
            if(!idx.containsKey(key)){
                idx.put(key, i);
            }
        }
        Arrays.sort(intervals, (a, b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int[] result=new int[l];
        Arrays.fill(result, -1);
        for(int i=0; i<l; i++){
            int curIdx=idx.get(Arrays.asList(intervals[i][0], intervals[i][1]));
            for(int j=i+1; j<l; j++){
                if(intervals[j][0]>=intervals[i][1]){
                    result[curIdx]=idx.get(Arrays.asList(intervals[j][0], intervals[j][1]));
                    break;
                }
            }
        }
        return result;
    }
}

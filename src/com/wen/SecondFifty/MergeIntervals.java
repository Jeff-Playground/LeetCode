package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

//    // Find intervals based on sorted start and end
//    public List<Interval> merge(List<Interval> intervals) {
//        List<Interval> result=new ArrayList<Interval>();
//        if(intervals==null || intervals.size()==0){
//            return result;
//        }
//        int n=intervals.size();
//        int[] starts=new int[n];
//        int[] ends=new int[n];
//        for(int i=0; i<n; i++){
//            starts[i]=intervals.get(i).start;
//            ends[i]=intervals.get(i).end;
//        }
//        Arrays.sort(starts);
//        Arrays.sort(ends);
//        for(int i=0, j=0; i<n; i++){
//            if(i==n-1 || starts[i+1]>ends[i]){
//                result.add(new Interval(starts[j], ends[i]));
//                j=i+1;
//            }
//        }
//        return result;
//    }

    // Sort and merge
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0){
            return result;
        }
        intervals.sort((i1, i2)->i1.start-i2.start);
        result.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
            Interval last=result.get(result.size()-1);
            if(last.end>=intervals.get(i).start){
                last.end=Math.max(last.end,intervals.get(i).end);
            } else{
                result.add(intervals.get(i));
            }
        }
        return result;
    }
}

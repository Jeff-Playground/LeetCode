package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // Iterative2
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result=new ArrayList<Interval>();
        int n=intervals.size(), cur=0;
        for(int i=0; i<n; i++) {
            if(intervals.get(i).end<newInterval.start) {
                result.add(intervals.get(i));
                cur++;
            } else if(intervals.get(i).start>newInterval.end) {
                result.add(intervals.get(i));
            } else {
                newInterval.start=Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end=Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        result.add(cur, newInterval);
        return result;
    }

//    // Iterative1
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> result=new ArrayList<Interval>();
//        int n=intervals.size(), cur=0;
//        while(cur<n && intervals.get(cur).end<newInterval.start) {
//            result.add(intervals.get(cur++));
//        }
//        while(cur<n && intervals.get(cur).start<=newInterval.end) {
//            newInterval.start=Math.min(newInterval.start, intervals.get(cur).start);
//            newInterval.end=Math.max(newInterval.end, intervals.get(cur++).end);
//        }
//        result.add(newInterval);
//        while(cur<n) {
//            result.add(intervals.get(cur++));
//        }
//        return result;
//    }
}

package com.wen.SixteenthFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LQEmployeeFreeTime {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result=new ArrayList<>();
        List<Interval> sorted=new ArrayList<>();
        for(List<Interval> s: schedule) {
            sorted.addAll(s);
        }
        Collections.sort(sorted, (a, b)->(a.start==b.start?a.end-b.end:a.start-b.start));
        int l=sorted.size();
        Interval last=sorted.get(0);
        for(int i=1; i<l; i++) {
            Interval cur=sorted.get(i);
            if(cur.start>last.end) {
                result.add(new Interval(last.end, cur.start));
            }
            last.end=Math.max(last.end, cur.end);
        }
        return result;
    }
}

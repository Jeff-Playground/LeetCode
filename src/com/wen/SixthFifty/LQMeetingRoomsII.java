package com.wen.SixthFifty;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LQMeetingRoomsII {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b)->a.start-b.start);
        Queue<Interval> q=new PriorityQueue<>((a, b)->a.end-b.end);
        for(Interval i: intervals){
            if(!q.isEmpty()){
                Interval first=q.peek();
                if(first.end<i.start){
                    q.poll();
                }
            }
            q.offer(i);
        }
        return q.size();
    }
}

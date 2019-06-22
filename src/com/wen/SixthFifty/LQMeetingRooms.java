package com.wen.SixthFifty;

import java.util.Collections;
import java.util.List;

public class LQMeetingRooms {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b)->a.start-b.start);
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start<intervals.get(i-1).end){
                return false;
            }
        }
        return true;
    }
}

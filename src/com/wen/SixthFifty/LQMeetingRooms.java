package com.wen.SixthFifty;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: [[7,10],[2,4]]
Output: true

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

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

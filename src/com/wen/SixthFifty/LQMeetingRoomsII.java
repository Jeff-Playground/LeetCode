package com.wen.SixthFifty;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the
minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

import java.util.*;

public class LQMeetingRoomsII {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        int n=intervals.size();
        int[] starts=new int[n], ends=new int[n];
        for(int i=0; i<n; i++){
            starts[i]=intervals.get(i).start;
            ends[i]=intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int endIndex=0, result=0;
        for(int i=0; i<n; i++){
            if(starts[i]<ends[endIndex]){
                result++;
            } else{
                endIndex++;
            }
        }
        return result;
    }

//    public int minMeetingRooms(List<Interval> intervals) {
//        Map<Integer, Integer> map=new TreeMap<>();
//        for(Interval i: intervals){
//            map.put(i.start, map.getOrDefault(i.start, 0)+1);
//            map.put(i.end, map.getOrDefault(i.end, 0)-1);
//        }
//        int rooms=0, result=0;
//        for(int v: map.values()){
//            rooms+=v;
//            result=Math.max(result, rooms);
//        }
//        return result;
//    }

//    // Heap
//    public int minMeetingRooms(List<Interval> intervals) {
//        Collections.sort(intervals, (a, b)->a.start-b.start);
//        PriorityQueue<Interval> q=new PriorityQueue<>((a, b)->a.end-b.end);
//        for(Interval i: intervals){
//            // Here it doesn't have to be a while loop and do Math.max every time because rooms are changed 1 at a time
//            // Poll only one time each time ensures when the last meeting starts after all meetings before ended won't
//            // produce wrong answer
//            // Can think of it like using a room checked out by the last polled meeting
//            if(!q.isEmpty()){
//                Interval first=q.peek();
//                if(first.end<i.start){
//                    q.poll();
//                }
//            }
//            q.offer(i);
//        }
//        return q.size();
//    }
}

package com.wen.SixthFifty;

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

//    public int minMeetingRooms(List<Interval> intervals) {
//        Collections.sort(intervals, (a, b)->a.start-b.start);
//        Queue<Interval> q=new PriorityQueue<>((a, b)->a.end-b.end);
//        for(Interval i: intervals){
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

package com.wen.FifteenthFifty;

import java.util.TreeMap;

public class MyCalendarIII {
    class MyCalendarThree {
        TreeMap<Integer, Integer> cal;

        public MyCalendarThree() {
            cal=new TreeMap<>();
        }

        public int book(int start, int end) {
            if(cal.containsKey(start)){
                cal.put(start, cal.get(start)+1);
            } else{
                cal.put(start, 1);
            }
            if(cal.containsKey(end)){
                cal.put(end, cal.get(end)-1);
            } else{
                cal.put(end, -1);
            }
            int cur=0, result=0;
            for(int val: cal.values()){
                cur+=val;
                result=Math.max(result, cur);
            }
            return result;
        }
    }
}

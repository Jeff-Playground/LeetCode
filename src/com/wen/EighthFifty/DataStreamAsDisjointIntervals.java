package com.wen.EighthFifty;

import java.util.*;

public class DataStreamAsDisjointIntervals {
    public static class SummaryRanges {
        TreeMap<Integer, Integer> ranges;
        Set<Integer> added;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            ranges=new TreeMap<>();
            added=new HashSet<>();
        }

        public void addNum(int val) {
            if(!added.contains(val)){
                added.add(val);
                Integer floor=ranges.floorKey(val), ceiling=ranges.ceilingKey(val);
                if(floor!=null && ranges.get(floor)==val-1){
                    ranges.put(floor, val);
                    if(ceiling!=null && ceiling==ranges.get(floor)+1){
                        ranges.put(floor, ranges.get(ceiling));
                        ranges.remove(ceiling);
                    }
                } else if(ceiling!=null && ceiling==val+1){
                    if(floor!=null && ranges.get(floor)==val-1){
                        ranges.put(floor, ranges.get(ceiling));
                    } else{
                        ranges.put(val, ranges.get(ceiling));
                    }
                    ranges.remove(ceiling);
                } else{
                    ranges.put(val, val);
                }
            }
        }

        public int[][] getIntervals() {
            if(ranges.size()>0){
                int[][] result=new int[ranges.size()][2];
                Iterator<Integer> it=ranges.keySet().iterator();
                for(int i=0; i<ranges.size(); i++){
                    int key=it.next();
                    result[i][0]=key;
                    result[i][1]=ranges.get(key);
                }
                return result;
            } else{
                return null;
            }
        }
    }

    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(val);
     * int[][] param_2 = obj.getIntervals();
     */
}

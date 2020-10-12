package com.wen.FifteenthFifty;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RangeModule {
    // TreeMap
    class Solution {
        TreeMap<Integer, Integer> ranges;

        public Solution() {
            ranges=new TreeMap<>();
        }

        public void addRange(int left, int right) {
            if(left>=right){
                return;
            }
            Integer start=ranges.floorKey(left), end=ranges.floorKey(right);
            if(start==null && end==null){
                ranges.put(left, right);
            } else if(start!=null && ranges.get(start)>=left){
                ranges.put(start, Math.max(ranges.get(end), Math.max(ranges.get(start), right)));
            } else{
                ranges.put(left, Math.max(ranges.get(end), right));
            }
            Map<Integer, Integer> subMap=ranges.subMap(left, false, right, true);
            ranges.keySet().removeAll(new HashSet<>(subMap.keySet()));
        }

        public boolean queryRange(int left, int right) {
            Integer floorKey=ranges.floorKey(left);
            return floorKey!=null && ranges.get(floorKey)>=right;
        }

        public void removeRange(int left, int right) {
            if(left>=right){
                return;
            }
            Integer start=ranges.floorKey(left), end=ranges.floorKey(right);
            if(end!=null && ranges.get(end)>right){
                ranges.put(right, ranges.get(end));
            }
            if(start!=null && ranges.get(start)>left){
                ranges.put(start, left);
            }
            Map<Integer, Integer> subMap=ranges.subMap(left, true, right, false);
            ranges.keySet().removeAll(new HashSet<>(subMap.keySet()));
        }
    }
}

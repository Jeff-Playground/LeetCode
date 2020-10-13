package com.wen.FifteenthFifty;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RangeModule {
    // Segment tree
    class Solution {

        private SegmentNode root;

        public Solution() {
            root=new SegmentNode(0, (int)Math.pow(10, 9), false);
        }

        public void addRange(int left, int right) {
            update(root, left, right, true);
        }

        public boolean queryRange(int left, int right) {
            return query(root, left, right);
        }

        public void removeRange(int left, int right) {
            update(root, left, right, false);
        }

        private boolean update(SegmentNode cur, int l, int r, boolean state){
            if(l<=cur.start && r>=cur.end){
                cur.state=state;
                cur.left=null;
                cur.right=null;
                return cur.state;
            }
            if(l>=cur.end || r<=cur.start){
                return cur.state;
            }
            int mid=cur.start+(cur.end-cur.start)/2;
            if(cur.left==null){
                cur.left=new SegmentNode(cur.start, mid, cur.state);
                cur.right=new SegmentNode(mid, cur.end, cur.state);
            }
            boolean left=update(cur.left, l, r, state);
            boolean right=update(cur.right, l, r, state);
            cur.state=left&&right;
            return cur.state;
        }

        private boolean query(SegmentNode cur, int l, int r){
            if(l>=cur.end || r<=cur.start){
                return true;
            }
            if((l<=cur.start && r>=cur.end) || cur.left==null){
                return cur.state;
            }
            int mid=cur.start+(cur.end-cur.start)/2;
            if(r<=mid){
                return query(cur.left, l, r);
            } else if(l>=mid){
                return query(cur.right, l, r);
            } else{
                return query(cur.left, l, r) && query(cur.right, l, r);
            }
        }

        private class SegmentNode{
            public int start, end;
            public boolean state;
            public SegmentNode left, right;
            public SegmentNode(int start, int end, boolean state){
                this.start=start;
                this.end=end;
                this.state=state;
            }
        }
    }

//    // TreeMap
//    class Solution {
//        TreeMap<Integer, Integer> ranges;
//
//        public Solution() {
//            ranges=new TreeMap<>();
//        }
//
//        public void addRange(int left, int right) {
//            if(left>=right){
//                return;
//            }
//            Integer start=ranges.floorKey(left), end=ranges.floorKey(right);
//            if(start==null && end==null){
//                ranges.put(left, right);
//            } else if(start!=null && ranges.get(start)>=left){
//                ranges.put(start, Math.max(ranges.get(end), Math.max(ranges.get(start), right)));
//            } else{
//                ranges.put(left, Math.max(ranges.get(end), right));
//            }
//            Map<Integer, Integer> subMap=ranges.subMap(left, false, right, true);
//            ranges.keySet().removeAll(new HashSet<>(subMap.keySet()));
//        }
//
//        public boolean queryRange(int left, int right) {
//            Integer floorKey=ranges.floorKey(left);
//            return floorKey!=null && ranges.get(floorKey)>=right;
//        }
//
//        public void removeRange(int left, int right) {
//            if(left>=right){
//                return;
//            }
//            Integer start=ranges.floorKey(left), end=ranges.floorKey(right);
//            if(end!=null && ranges.get(end)>right){
//                ranges.put(right, ranges.get(end));
//            }
//            if(start!=null && ranges.get(start)>left){
//                ranges.put(start, left);
//            }
//            Map<Integer, Integer> subMap=ranges.subMap(left, true, right, false);
//            ranges.keySet().removeAll(new HashSet<>(subMap.keySet()));
//        }
//    }
}

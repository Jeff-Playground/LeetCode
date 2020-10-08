package com.wen.FifteenthFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarII {
//    // Use a TreeMap to store all time points, for start +1, for end -1, and after inserting check the sum at all points,
//    // if at any point sum>=2, the latest insert is invalid and should be removed
//    public static class MyCalendarTwo {
//        TreeMap<Integer, Integer> cal;
//
//        public MyCalendarTwo() {
//            cal=new TreeMap<>();
//        }
//
//        public boolean book(int start, int end) {
//            cal.put(start, cal.getOrDefault(start, 0)+1);
//            cal.put(end, cal.getOrDefault(end, 0)-1);
//            int cur=0;
//            for(int val: cal.values()){
//                cur+=val;
//                if(cur>2){
//                    cal.put(start, cal.get(start)-1);
//                    cal.put(end, cal.get(end)+1);
//                    return false;
//                }
//            }
//            return true;
//        }
//    }

    public static class MyCalendarTwo {
        List<int[]> cal, overlap;

        public MyCalendarTwo() {
            cal=new ArrayList<>();
            overlap=new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int oIdx=findIdx(overlap, start);
            int left=oIdx-1, right=oIdx;
            int min=left>=0?overlap.get(left)[1]:Integer.MIN_VALUE;
            int max=right<overlap.size()?overlap.get(right)[0]:Integer.MAX_VALUE;
            if(start<min || end>max){
                return false;
            }
            int cIdx=findIdx(cal, start);
            left=cIdx-1;
            right=cIdx;
            // Note here it doesn't necessarily only have overlap with the closest gaps
            for(int i=left; i>=0; i--){
                insertOverlap(overlap, cal, i, start, end);
            }
            for(int i=right; i<cal.size(); i++){
                insertOverlap(overlap, cal, i, start, end);
            }
            cal.add(cIdx, new int[]{start, end});
            return true;
        }

        private void insertOverlap(List<int[]> overlap, List<int[]> cal, int idx, int start, int end){
            int[] cur=cal.get(idx);
            int max=Math.max(cur[0], start), min=Math.min(cur[1], end);
            if(max<min){
                int oIdx=findIdx(overlap, max);
                overlap.add(oIdx, new int[]{max, min});
            }
        }

        private int findIdx(List<int[]> a, int t){
            if(a.size()==0 || a.get(0)[0]>=t){
                return 0;
            } else if(a.get(a.size()-1)[0]<t){
                return a.size();
            } else{
                int left=0, right=a.size()-1;
                while(left<right){
                    int mid=left+(right-left)/2;
                    if(a.get(mid)[0]<t){
                        left=mid+1;
                    } else{
                        right=mid;
                    }
                }
                return left;
            }
        }
    }
}

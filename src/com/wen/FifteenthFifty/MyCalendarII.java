package com.wen.FifteenthFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarII {
    public static class MyCalendarTwo {
        TreeMap<Integer, Integer> cal;

        public MyCalendarTwo() {
            cal=new TreeMap<>();
        }

        public boolean book(int start, int end) {
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
            int cur=0;
            for(int val: cal.values()){
                cur+=val;
                if(cur>2){
                    cal.put(start, cal.get(start)-1);
                    cal.put(end, cal.get(end)+1);
                    return false;
                }
            }
            return true;
        }
    }

//    public static class MyCalendarTwo {
//        List<int[]> cal;
//        List<int[]> overlap;
//
//        public MyCalendarTwo() {
//            cal=new ArrayList<>();
//            overlap=new ArrayList<>();
//        }
//
//        public boolean book(int start, int end) {
//            int idx=findIdx(cal, start);
//            int left=idx-1, right=idx;
//            List<int[]> possibleOverlap=new ArrayList<>();
//            for(int i=left; i>=0; i--){
//                if(cal.get(i)[1]>start){
//                    if(!validOverlap(start, Math.min(cal.get(i)[1], end))){
//                        return false;
//                    } else{
//                        possibleOverlap.add(new int[]{start, Math.min(cal.get(i)[1], end)});
//                    }
//                }
//            }
//            for(int i=right; i<cal.size(); i++){
//                if(cal.get(i)[0]<end){
//                    if(!validOverlap(Math.max(cal.get(i)[0], start), end)){
//                        return false;
//                    } else{
//                        possibleOverlap.add(new int[]{Math.max(cal.get(i)[0], start), end});
//                    }
//                }
//            }
//            for(int[] overlap: possibleOverlap){
//                insertOverlap(overlap[0], overlap[1]);
//            }
//            cal.add(idx, new int[]{start, end});
//            return true;
//        }
//
//        private void insertOverlap(int start, int end) {
//            int idx=findIdx(overlap, start);
//            overlap.add(idx, new int[]{start, end});
//        }
//
//        public boolean validOverlap(int start, int end){
//            int idx=findIdx(overlap, start);
//            int left=idx-1, right=idx;
//            int min=left>=0?overlap.get(left)[1]:Integer.MIN_VALUE, max=right<overlap.size()?overlap.get(right)[0]:Integer.MAX_VALUE;
//            if(start>=min && end<=max){
//                return true;
//            } else{
//                return false;
//            }
//        }
//
//        private int findIdx(List<int[]> list, int val){
//            if(list.size()==0){
//                return 0;
//            } else if(list.size()==1){
//                return list.get(0)[0]>val?0:1;
//            } else{
//                int left=0, right=list.size()-1;
//                while(left<right){
//                    int mid=left+(right-left)/2;
//                    if(list.get(mid)[0]<=val){
//                        left=mid+1;
//                    } else{
//                        right=mid;
//                    }
//                }
//                return list.get(left)[0]>val?left:left+1;
//            }
//        }
//    }
}

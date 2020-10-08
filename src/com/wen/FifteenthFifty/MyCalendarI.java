package com.wen.FifteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarI {
    // The idea is to insert new bookings into an array by finding the idx it should fall at with the start time using
    // binary search, then check if the previous and next one has conflict with it
    public static class MyCalendar {
        List<int[]> cal;

        public MyCalendar() {
            cal=new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int idx=findIdx(start);
            int left=idx-1, right=idx;
            int min=left>=0?cal.get(left)[1]:Integer.MIN_VALUE, max=right<cal.size()?cal.get(right)[0]:Integer.MAX_VALUE;
            if(start>=min && end<=max){
                cal.add(idx, new int[]{start, end});
                return true;
            } else{
                return false;
            }
        }

        // findIdx finds the idx the new start should be inserted to
        private int findIdx(int val){
            if(cal.size()==0){
                return 0;
            } else if(cal.size()==1){
                return cal.get(0)[0]>val?0:1;
            } else{
                int left=0, right=cal.size()-1;
                while(left<right){
                    int mid=left+(right-left)/2;
                    if(cal.get(mid)[0]<=val){
                        left=mid+1;
                    } else{
                        right=mid;
                    }
                }
                return cal.get(left)[0]>val?left:left+1;
            }
        }
    }
}

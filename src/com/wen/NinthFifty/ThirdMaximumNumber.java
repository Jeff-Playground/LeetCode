package com.wen.NinthFifty;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMaximumNumber {
    // Time complexity O(nlogn)
    public int thirdMax(int[] nums) {
        Set<Integer> set=new TreeSet<>(Collections.reverseOrder());
        for(int num: nums){
            set.add(num);
        }
        return set.size()>=3?(int) set.toArray()[2]:(int) set.toArray()[0];
    }

//    // Time complexity O(n)
//    public int thirdMax(int[] nums) {
//        // Use long in case there are Int.MIN_VALUE in nums
//        long first=Long.MIN_VALUE, second=Long.MIN_VALUE, third=Long.MIN_VALUE;
//        for(int num: nums) {
//            if(num>first) {
//                third=second;
//                second=first;
//                first=num;
//            } else if(num<first && num>second) {
//                third=second;
//                second=num;
//            } else if(num<second && num>third) {
//                third=num;
//            }
//        }
//        return third==Long.MIN_VALUE?(int)first:(int)third;
//    }
}

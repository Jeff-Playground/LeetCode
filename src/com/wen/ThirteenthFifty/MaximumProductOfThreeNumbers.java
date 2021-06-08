package com.wen.ThirteenthFifty;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    // Time complexity O(n), but similar to the other solution
    public int maximumProduct(int[] nums) {
        int l=nums.length;
        if(l==3){
            return nums[0]*nums[1]*nums[2];
        } else{
            int mx1, mx2, mx3, mn1, mn2;
            mx1=mx2=mx3=Integer.MIN_VALUE;
            mn1=mn2=Integer.MAX_VALUE;
            for(int num: nums){
                if(num>mx1){
                    mx3=mx2;
                    mx2=mx1;
                    mx1=num;
                } else if(num>mx2){
                    mx3=mx2;
                    mx2=num;
                } else if(num>mx3){
                    mx3=num;
                }
                if(num<mn1){
                    mn2=mn1;
                    mn1=num;
                } else if(num<mn2){
                    mn2=num;
                }
            }
            return Math.max(mx1*mx2*mx3, mn1*mn2*mx1);
        }
    }

//    // Time complexity O(nlogn) due to sorting
//    public int maximumProduct(int[] nums) {
//        int l=nums.length;
//        if(l==3){
//            return nums[0]*nums[1]*nums[2];
//        } else{
//            Arrays.sort(nums);
//            // When all nums are positive or when all nums are negative or when only 1 negative in nums
//            int result1=nums[l-1]*nums[l-2]*nums[l-3];
//            // When more than 2 negative in nums and the maximum is non-negative
//            int result2=nums[0]*nums[1]*nums[l-1];
//            return Math.max(result1, result2);
//        }
//    }
}

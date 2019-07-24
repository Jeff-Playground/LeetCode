package com.wen.SixthFifty;

import java.util.Arrays;
import java.util.Stack;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==mid){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return right;
    }

//    // Bit manipulation
//    public int missingNumber(int[] nums) {
//        int result=0;
//        for(int i=0; i<nums.length; i++){
//            // Here the xor do (i+1) instead of i because result was originally 0, so can't do 0^0^0
//            result^=(i+1)^nums[i];
//        }
//        return result;
//    }

//    public int missingNumber(int[] nums) {
//        int n=nums.length;
//        int sum=(0+n)*(n+1)/2;
//        int result=sum;
//        for(int num:nums){
//            result-=num;
//        }
//        return result;
//    }
}

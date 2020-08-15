package com.wen.TenthFifty;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    // This is sort the array and use each element as the final reached point to calculate the result
    // Note within the calculation there're multiple casting places to avoid overflow
    // Another possible way to avoid overflow is to do: long temp=nums[i]
    public static int minMoves2(int[] nums) {
        int l=nums.length;
        long sum=0;
        Arrays.sort(nums);
        for(int num: nums){
            sum+=num;
        }
        long curSum=0, result=Long.MAX_VALUE;
        for(int i=0; i<l; i++){
            curSum+=nums[i];
            result=Math.min(result, (long)(i+1)*nums[i]-curSum+sum-curSum-(long)(l-i-1)*nums[i]);
        }
        return (int)result;
    }

//    public int minMoves2(int[] nums) {
//        int l=nums.length, sum=0;
//        Arrays.sort(nums);
//        int result=0, i=0, j=l-1;
//        while(i<j){
//            result+=nums[j--]-nums[i++];
//        }
//        return result;
//    }

//    public int minMoves2(int[] nums) {
//        int l=nums.length, sum=0;
//        Arrays.sort(nums);
//        int result=0, mid=nums[l/2];
//        for(int num: nums){
//            result+=Math.abs(num-mid);
//        }
//        return result;
//    }
}

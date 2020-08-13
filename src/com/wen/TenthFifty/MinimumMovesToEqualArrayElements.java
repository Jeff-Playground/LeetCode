package com.wen.TenthFifty;

public class MinimumMovesToEqualArrayElements {
    // The idea here is doing +1 for n-1 elements is similar to doing -1 for the maximum value, and eventually all numbers
    // need to become the minimum value
    public int minMoves(int[] nums) {
        if(nums==null || nums.length<=1){
            return 0;
        } else{
            int l=nums.length, min=Integer.MAX_VALUE;
            long sum=0;
            for(int num: nums){
                min=Math.min(min, num);
                sum+=num;
            }
            return (int)(sum-min*l);
        }
    }

//    public int minMoves(int[] nums) {
//        if(nums==null || nums.length<=1){
//            return 0;
//        } else{
//            int l=nums.length, min=Integer.MAX_VALUE;
//            for(int num: nums){
//                min=Math.min(min, num);
//            }
//            int result=0;
//            for(int num: nums){
//                result+=num-min;
//            }
//            return result;
//        }
//    }
}

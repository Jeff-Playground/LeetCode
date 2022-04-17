package com.wen.FifteenthFifty;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        int cur=0;
        for(int i=0; i<nums.length; i++){
            if(2*cur==sum-nums[i]){
                return i;
            }
            cur+=nums[i];
        }
        return -1;
    }
}

package com.wen.FifteenthFifty;

public class LargestNumberAtLeastTwiceOfOthers {
    // Two pointers
    public int dominantIndex(int[] nums) {
        int max=-1, secondMax=-1, l=nums.length;
        for(int i=0; i<l; i++){
            if(max==-1){
                max=i;
            } else if(nums[i]>nums[max]){
                secondMax=max;
                max=i;
            } else if(secondMax==-1 || nums[i]>nums[secondMax]){
                secondMax=i;
            }
        }
        return nums[max]>=nums[secondMax]*2?max:-1;
    }
}

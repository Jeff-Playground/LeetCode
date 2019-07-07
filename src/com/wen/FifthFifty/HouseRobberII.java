package com.wen.FifthFifty;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    public int rob(int[] nums, int left, int right) {
        if(left>right) {
            return 0;
        }
        if(left==right) {
            return nums[left];
        }
        int rob=0, notRob=0;
        for(int i=left; i<=right; i++) {
            int preNotRob=notRob;
            notRob=Math.max(rob, notRob);
            rob=preNotRob+nums[i];
        }
        return Math.max(rob, notRob);
    }
}

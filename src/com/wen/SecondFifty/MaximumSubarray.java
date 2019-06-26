package com.wen.SecondFifty;

public class MaximumSubarray {
    // DP
    public int maxSubArray(int[] nums) {
        int result=Integer.MIN_VALUE;
        int curSum=0;
        for(int num: nums) {
            curSum=Math.max(curSum+num, num);
            result=Math.max(result, curSum);
        }
        return result;
    }

//    // Recursive
//    public int maxSubArray(int[] nums) {
//        if(nums.length==0) {
//            return 0;
//        } else {
//            return helper(nums, 0, nums.length-1);
//        }
//    }
//
//    private int helper(int[] nums, int left, int right) {
//        if(left>=right) {
//            return nums[left];
//        }
//        int mid=left+(right-left)/2;
//        int lmax=helper(nums, left, mid-1);
//        int rmax=helper(nums, mid+1, right);
//        int mmax=nums[mid], t=mmax;
//        for(int i=mid-1; i>=left; i--) {
//            t+=nums[i];
//            mmax=Math.max(mmax, t);
//        }
//        t=mmax;
//        for(int i=mid+1; i<=right; i++) {
//            t+=nums[i];
//            mmax=Math.max(mmax, t);
//        }
//        return Math.max(mmax, Math.max(lmax, rmax));
//    }
}

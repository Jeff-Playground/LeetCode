package com.wen.SecondFifty;

public class MaximumSubarray {
//    // DP
//    // dp[i] stands for the maximum sum ending with nums[i]
//    public int maxSubArray(int[] nums) {
//        int l=nums.length, result=Integer.MIN_VALUE;
//        int[] dp=new int[l];
//        for(int i=0; i<l; i++){
//            if(i==0 || dp[i-1]<0){
//                dp[i]=nums[i];
//            } else{
//                dp[i]=dp[i-1]+nums[i]>0?dp[i-1]+nums[i]:0;
//            }
//            result=Math.max(result, dp[i]);
//        }
//        return result;
//    }

    // As dp[i] only depends on dp[i-1], dp can be optimized as below
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

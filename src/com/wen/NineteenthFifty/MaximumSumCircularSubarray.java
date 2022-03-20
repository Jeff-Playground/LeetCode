package com.wen.NineteenthFifty;

public class MaximumSumCircularSubarray {
    // DP
    // Similar to Maximum Subarray, compute a maxSum just like Maximum Subarray, and compute a minSum which is the minimum
    // subarray, then (sum-minSum) is the maxSum that locates at the start and end sides of the array
    // Note the edge case when all elements are negative, then sum-minSum would be 0 which will be bigger than maxSum which
    // would be negative, but still should return maxSum
    public int maxSubarraySumCircular(int[] nums) {
        int l=nums.length;
        int curMaxSum=0, maxSum=Integer.MIN_VALUE, curMinSum=0, minSum=Integer.MAX_VALUE, sum=0;
        for(int num: nums){
            sum+=num;
            curMaxSum=Math.max(curMaxSum+num, num);
            maxSum=Math.max(maxSum, curMaxSum);
            curMinSum=Math.min(curMinSum+num, num);
            minSum=Math.min(minSum, curMinSum);
        }
        return sum-minSum==0?maxSum:Math.max(maxSum, sum-minSum);
    }
}

package com.wen.ThirteenthFifty;

public class MaximumAverageSubarrayI {
//    // Sliding window
//    public double findMaxAverage(int[] nums, int k) {
//        int n=nums.length;
//        double sum=0;
//        for(int i=0; i<k; i++){
//            sum+=nums[i];
//        }
//        double max=sum;
//        for(int i=k; i<n; i++){
//            sum=sum-nums[i-k]+nums[i];
//            max=Math.max(sum, max);
//        }
//        return max/k;
//    }

    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        long[] sum=new long[n];
        sum[0]=nums[0];
        for(int i=1; i<n; i++){
            sum[i]=sum[i-1]+nums[i];
        }
        double max=sum[k-1];
        for(int i=k; i<n; i++){
            max=Math.max(max, sum[i]-sum[i-k]);
        }
        return max/k;
    }
}

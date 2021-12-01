package com.wen.ThirteenthFifty;

/*
Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k that
has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation:
when length is 5, maximum average value is 10.8,
when length is 6, maximum average value is 9.16667.
Thus return 12.75.


Note:

1 <= k <= n <= 10,000.
Elements of the given array will be in range [-10,000, 10,000].
The answer with the calculation error less than 10-5 will be accepted.
 */

public class LQMaximumAverageSubarrayII {
//    // Brute force, will TLE, time complexity O(n^2)
//    public static double maxAverage(int[] nums, int k) {
//        int n=nums.length;
//        double[] sum=new double[n];
//        sum[0]=nums[0];
//        for(int i=1; i<n; i++){
//            sum[i]=sum[i-1]+nums[i];
//        }
//        // Note how we can't use Double.MIN_VALUE here as it stands for the minimum absolute value
//        double result=-Double.MAX_VALUE;
//        for(int i=k; i<=n; i++){
//            for(int j=i-1; j<n; j++){
//                result=Math.max(result, (sum[j]-(j-i<0?0.0:sum[j-i]))/i);
//            }
//        }
//        return result;
//    }

//    // Optimized brute force, multiply is faster than divide, but still TLE, time complexity O(n^2)
//    public static double maxAverage(int[] nums, int k) {
//        int n=nums.length;
//        double[] sum=new double[n];
//        sum[0]=nums[0];
//        for(int i=1; i<n; i++){
//            sum[i]=sum[i-1]+nums[i];
//        }
//        double result=sum[k-1]/k;
//        for(int i=k; i<=n; i++){
//            for(int j=i-1; j<n; j++){
//                double curSum=sum[j]-(j-i<0?0.0:sum[j-i]);
//                if(result*i<curSum){
//                    result=curSum/i;
//                }
//            }
//        }
//        return result;
//    }

//    // Binary search, time complexity O(n+nlg(max - min))
//    public double maxAverage(int[] nums, int k) {
//        int n=nums.length;
//        double[] sum=new double[n];
//        double left=Double.MAX_VALUE, right=-Double.MAX_VALUE;
//        for(int i=0; i<n; i++){
//            left=Math.min(nums[i], left);
//            right=Math.max(nums[i], right);
//        }
//        while(right-left>1e-5){
//            double mid=left+(right-left)/2, minSum=0;
//            boolean midTooSmall=false;
//            sum[0]=nums[0]-mid;
//            for(int i=1; i<n; i++){
//                sum[i]=sum[i-1]+nums[i]-mid;
//                if(i+1>=k){
//                    minSum=Math.min(minSum, i-k>=0?sum[i-k]:0);
//                    if(sum[i]>minSum){
//                        midTooSmall=true;
//                        break;
//                    }
//                }
//            }
//            if(midTooSmall){
//                left=mid;
//            } else{
//                right=mid;
//            }
//        }
//        return right;
//    }

    // Optimized bianry search with lower space complexity, time complexity O(n+nlg(max - min))
    public double maxAverage(int[] nums, int k) {
        int n=nums.length;
        double left=Double.MAX_VALUE, right=-Double.MAX_VALUE;
        for(int i=0; i<n; i++){
            left=Math.min(left, nums[i]);
            right=Math.max(right, nums[i]);
        }
        while(right-left>1e-5){
            double mid=left+(right-left)/2, preSum=0, curSum=0, minSum=0;
            boolean midTooSmall=false;
            for(int i=0; i<n; i++){
                curSum+=nums[i]-mid;
                if(i+1>=k){
                    preSum+=i-k>=0?nums[i-k]-mid:0;
                    minSum=Math.min(minSum, preSum);
                    if(curSum>minSum){
                        midTooSmall=true;
                        break;
                    }
                }
            }
            if(midTooSmall){
                left=mid;
            } else{
                right=mid;
            }
        }
        return right;
    }
}

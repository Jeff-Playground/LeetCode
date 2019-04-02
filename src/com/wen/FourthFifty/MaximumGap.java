package com.wen.FourthFifty;

import java.util.*;

public class MaximumGap {
    // Bucket sort
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<2) {
            return 0;
        }
        int maxGap=0;
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, n=nums.length;
        for(int num: nums) {
            max=Math.max(max, num);
            min=Math.min(min, num);
        }
        // Ensures gap between buckets are bigger than within a bucket
        int bucketSize=(max-min)/n+1;
        int bucketCount=(max-min)/bucketSize+1;
        int[] bucketMax=new int[bucketCount];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        int[] bucketMin=new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Set<Integer> existingIdx=new HashSet<>();
        for(int num: nums) {
            int idx=(num-min)/bucketSize;
            bucketMax[idx]=Math.max(bucketMax[idx], num);
            bucketMin[idx]=Math.min(bucketMin[idx], num);
            existingIdx.add(idx);
        }
        int pre=0;
        for(int i=1; i<n; i++) {
            if(!existingIdx.contains(i)) {
                continue;
            }
            maxGap=Math.max(maxGap, bucketMin[i]-bucketMax[pre]);
            pre=i;
        }
        return maxGap;
    }

//    // Radix sort
//    public int maximumGap(int[] nums) {
//        if(nums==null || nums.length<2) {
//            return 0;
//        }
//        int max=Integer.MIN_VALUE;
//        for(int num: nums) {
//            max=Math.max(max, num);
//        }
//        int radix=10, exp=1;
//        int[] sorted=new int[nums.length];
//        while(max/exp>0) {
//            int[] count=new int[radix];
//            for(int num: nums) {
//                count[num/exp%10]++;
//            }
//            for(int i=1; i<radix; i++) {
//                count[i]+=count[i-1];
//            }
//            for(int i=nums.length-1; i>=0; i--) {
//                sorted[--count[nums[i]/exp%10]]=nums[i];
//            }
//            for(int i=0; i<nums.length; i++) {
//                nums[i]=sorted[i];
//            }
//            exp*=10;
//        }
//        int maxGap=0;
//        for(int i=1; i<nums.length; i++) {
//            maxGap=Math.max(maxGap, nums[i]-nums[i-1]);
//        }
//        return maxGap;
//    }
}

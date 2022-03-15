package com.wen.FourthFifty;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    // DP top down
    public int rob(int[] nums) {
        Map<Integer, Integer> cache=new HashMap<>();
        cache.put(0, nums[0]);
        if(nums.length>1){
            cache.put(1, Math.max(nums[0], nums[1]));
        }
        return robHelper(nums, cache, nums.length-1);
    }

    private int robHelper(int[] nums, Map<Integer, Integer> cache, int i){
        if(!cache.containsKey(i)){
            cache.put(i, Math.max(robHelper(nums, cache, i-2)+nums[i], robHelper(nums, cache, i-1)));
        }
        return cache.get(i);
    }

//    // DP bottom up, dp[i] stands for the maximum money can be got at house i
//    public int rob(int[] nums) {
//        if(nums==null || nums.length==0) {
//            return 0;
//        }
//        int[] dp=new int[nums.length];
//        for(int i=0; i<nums.length; i++) {
//            if(i==0) {
//                dp[i]=nums[0];
//            } else if(i==1) {
//                if(nums[1]>nums[0]) {
//                    dp[i]=nums[1];
//                } else {
//                    dp[i]=nums[0];
//                }
//            } else {
//                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
//            }
//        }
//        return dp[nums.length-1];
//    }
}

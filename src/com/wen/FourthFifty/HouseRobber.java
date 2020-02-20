package com.wen.FourthFifty;

public class HouseRobber {
    // DP
    // dp[i][0] stands for the max money made not robbing house i, dp[i][1] for the max money made robbing house i
    public static int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[][] dp=new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            if(i==0){
                dp[i][0]=0;
                dp[i][1]=nums[i];
            } else if(i==1){
                dp[i][0]=dp[i-1][1];
                dp[i][1]=nums[i];
            } else{
                dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
                dp[i][1]=dp[i-1][0]+nums[i];
            }
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }

//    // Optimized DP
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

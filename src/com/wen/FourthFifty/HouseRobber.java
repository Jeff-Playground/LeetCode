package com.wen.FourthFifty;

public class HouseRobber {
    public static int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[][] dp=new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            if(i<=1){
                dp[i][0]=1;
                dp[i][1]=nums[i];
            } else{
                if(dp[i-1][0]==1){
                    dp[i][1]=dp[i-1][1];
                } else{
                    dp[i][0]=1;
                    dp[i][1]=dp[i-1][1]+nums[i];
                }
            }
        }
        return dp[nums.length-1][1];
    }
}

package com.wen.NinthFifty;

public class PartitionEqualSubsetSum {
    // Optimized DP with one dimensional array
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2==1){
            return false;
        }
        int l=nums.length;
        boolean[] dp=new boolean[sum/2+1];
        dp[0]=true;
        for(int i=1; i<l+1; i++){
            for(int j=sum/2; j>=0; j--){
                if(nums[i-1]<=j){
                    dp[j]=dp[j] || dp[j-nums[i-1]];
                } else{
                    dp[j]=dp[j];
                }
            }
        }
        return dp[sum/2];
    }

//    // DP, 0-1 knapsack
//    public static boolean canPartition(int[] nums) {
//        int sum=0;
//        for(int num: nums){
//            sum+=num;
//        }
//        if(sum%2==1){
//            return false;
//        }
//        int l=nums.length;
//        boolean[][] dp=new boolean[l+1][sum/2+1];
//        for(int i=0; i<l+1; i++){
//            dp[i][0]=true;
//        }
//        for(int i=1; i<l+1; i++){
//            for(int j=1; j<sum/2+1; j++){
//                if(nums[i-1]<=j){
//                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
//                } else{
//                    dp[i][j]=dp[i-1][j];
//                }
//            }
//        }
//        return dp[l][sum/2];
//    }
}

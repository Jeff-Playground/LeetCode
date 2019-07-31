package com.wen.TenthFifty;

public class TargetSum {
    // DP, 0-1 knapsack
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        S=Math.abs(S);
        if(S>sum || (sum+S)%2!=0){
            return 0;
        }
        int[][] dp=new int[(sum+S)/2+1][nums.length+1];
        dp[0][0]=1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                dp[0][i+1]=dp[0][i]*2;
            } else {
                dp[0][i+1]=dp[0][i];
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<nums.length; j++){
                dp[i][j+1]+=dp[i][j];
                if(nums[j]<=i){
                    dp[i][j+1]+=dp[i-nums[j]][j];
                }
            }
        }
        return dp[(sum+S)/2][nums.length];
    }

//    // DFS
//    public int findTargetSumWays(int[] nums, int S) {
//        int[] result=new int[]{0};
//        findTargetSumWaysDFS(nums, 0, S, result);
//        return result[0];
//    }
//
//    public void findTargetSumWaysDFS(int[] nums, int start, int target, int[] result){
//        if(start>nums.length-1){
//            return;
//        }
//        if(start==nums.length-1 && nums[start]==Math.abs(target)){
//            if(nums[start]>0){
//                result[0]++;
//            } else{
//                result[0]+=2;
//            }
//        }
//        findTargetSumWaysDFS(nums, start+1, target-nums[start], result);
//        findTargetSumWaysDFS(nums, start+1, target+nums[start], result);
//    }
}

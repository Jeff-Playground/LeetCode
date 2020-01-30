package com.wen.TenthFifty;

public class TargetSum {
    // DP, 0-1 knapsack optimized to one dimensional array
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        S=Math.abs(S);
        if(S>sum || (sum+S)%2==1){
            return 0;
        }
        int l=nums.length;
        int[] dp=new int[(sum+S)/2+1];
        dp[0]=1;
        for(int i=1; i<l+1; i++){
            // Note here j has to include 0 because it needs the part to handle nums[i-1]==0
            for(int j=(sum+S)/2; j>=0; j--){
                if(nums[i-1]==0){
                    dp[j]=2*dp[j];
                } else{
                    if(nums[i-1]<=j){
                        dp[j]=dp[j]+dp[j-nums[i-1]];
                    } else{
                        dp[j]=dp[j];
                    }
                }
            }
        }
        return dp[(sum+S)/2];
    }

//    // DP, 0-1 knapsack
//    // sPositive+sNegative=sum, sPositive-sNegative=S, so sPositive=(sum+S)/2
//    public int findTargetSumWays(int[] nums, int S) {
//        int sum=0;
//        for(int num: nums){
//            sum+=num;
//        }
//        S=Math.abs(S);
//        if(S>sum || (sum+S)%2==1){
//            return 0;
//        }
//        int l=nums.length;
//        int[][] dp=new int[l+1][(sum+S)/2+1];
//        dp[0][0]=1;
//        for(int i=1; i<l+1; i++){
//            // Here dp[i][0] means make sPositive=0, so except 0 items which can be in either group,
//            // put all other into sNegative
//            if(nums[i-1]==0){
//                dp[i][0]=2*dp[i-1][0];
//            } else{
//                dp[i][0]=dp[i-1][0];
//            }
//        }
//        for(int i=1; i<l+1; i++){
//            for(int j=1; j<(sum+S)/2+1; j++){
//                if(nums[i-1]<=j){
//                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
//                } else{
//                    dp[i][j]=dp[i-1][j];
//                }
//            }
//        }
//        return dp[l][(sum+S)/2];
//    }

//    // DFS
//    public int findTargetSumWays(int[] nums, int S) {
//        int[] result=new int[]{0};
//        findTargetSumWaysDFS(nums, 0, S, result);
//        return result[0];
//    }
//
//    public void findTargetSumWaysDFS(int[] nums, int start, int target, int[] result){
//        if(start==nums.length-1){
//            if(nums[start]==Math.abs(target)){
//                if(nums[start]>0){
//                    result[0]++;
//                } else{
//                    result[0]+=2;
//                }
//            }
//            return;
//        }
//        findTargetSumWaysDFS(nums, start+1, target-nums[start], result);
//        findTargetSumWaysDFS(nums, start+1, target+nums[start], result);
//    }
}

package com.wen.ThritySixthFifty;

public class MaximumScoreFromPerformingMultiplicationOperations {
    // DP, bottom up, dp[i][left] stands for the maximum score for state when multiplier needs to use the value at i and
    // nums can use the value at left or at (n-1-(i-left)), note (i-left) is the number of nums value used from the left
    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length, m=multipliers.length;
        int[][] dp=new int[m+1][m+1];
        for(int i=m-1; i>=0; i--){
            for(int left=0; left<=i; left++){
                int mult=multipliers[i];
                dp[i][left]=Math.max(dp[i+1][left]+mult*nums[n-1-(i-left)], dp[i+1][left+1]+mult*nums[left]);
            }
        }
        return dp[0][0];
    }

//    // DP, top down
//    public int maximumScore(int[] nums, int[] multipliers) {
//        int n=nums.length, m=multipliers.length;
//        int[][] memo=new int[m][m];
//        return dp(nums, multipliers, memo, 0, 0);
//    }
//
//    private int dp(int[] nums, int[] multipliers, int mIdx, int leftIdx, int[][] memo){
//        int n=nums.length, m=multipliers.length;
//        if(mIdx==m){
//            return 0;
//        }
//        if(memo[mIdx][leftIdx]==0){
//            int mult=multipliers[mIdx];
//            memo[mIdx][leftIdx]=Math.max(dp(nums, multipliers, memo, mIdx+1, leftIdx)+mult*nums[n-1-(mIdx-leftIdx)],
//                    dp(nums, multipliers, memo, mIdx+1, leftIdx+1)+mult*nums[leftIdx]);
//        }
//        return memo[mIdx][leftIdx];
//    }
}

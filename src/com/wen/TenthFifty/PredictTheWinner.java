package com.wen.TenthFifty;

import java.util.Arrays;

public class PredictTheWinner {
    // DP2
    public boolean PredictTheWinner(int[] nums) {
        int l=nums.length;
        int[][] dp=new int[l][l];
        for(int i=0; i<l; i++){
            dp[i][i]=nums[i];
        }
        for(int len=2; len<=l; len++){
            for(int start=0, end=len-1; end<l; start++, end++){
                dp[start][end]=Math.max(nums[start]-dp[start+1][end], nums[end]-dp[start][end-1]);
            }
        }
        return dp[0][l-1]>=0;
    }

//    // DP1
//    public static boolean PredictTheWinner(int[] nums) {
//        int l=nums.length;
//        int[][] dp=new int[l][l];
//        for(int i=0; i<l; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        return beatByScore(nums, dp, 0, l-1)>0;
//    }
//
//    private static int beatByScore(int[] nums, int[][] dp, int start, int end) {
//        if(dp[start][end]==-1){
//            dp[start][end]=start==end?nums[start]:Math.max(nums[start]-beatByScore(nums, dp, start+1, end), nums[end]-beatByScore(nums, dp, start, end-1));
//        }
//        return dp[start][end];
//    }

//    public static boolean PredictTheWinner(int[] nums) {
//        return canWin(nums, 0, nums.length-1, 0, 0, 1);
//    }
//
//    public static boolean canWin(int[] nums, int start, int end, int cur1, int cur2, int player){
//        if(start>end || start>nums.length-1 || end<0){
//            if(player==1){
//                return cur1>=cur2;
//            } else{
//                return cur2>cur1;
//            }
//        } else if(start==end){
//            if(player==1){
//                return cur1+nums[start]>=cur2;
//            } else{
//                return cur2+nums[start]>cur1;
//            }
//        } else{
//            if(player==1){
//                return !canWin(nums, start+1, end, cur1+nums[start], cur2, 2) || !canWin(nums, start, end-1, cur1+nums[end], cur2, 2);
//            } else{
//                return !canWin(nums, start+1, end, cur1, cur2+nums[start], 1) || !canWin(nums, start, end-1, cur1, cur2+nums[end], 1);
//            }
//        }
//    }
}

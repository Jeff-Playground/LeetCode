package com.wen.TenthFifty;

import java.util.Arrays;

public class PredictTheWinner {
    // DP2
    // dp[i][j] stands for the beatByScore for nums in [i, j]
    // Further optimized space complexity to O(n^2), as it's got rid of the running stack
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

//    // DP1, use dp to cache the intermediate result get by earlier calculation
//    // dp[i][j] stands for the beatByScore for nums in [i, j]
//    // Optimized time complexity to O(n^2), because there're n^2 values need to be calculated in total(size of dp)
//    // Space complexity: O(n^2+n), dp is n^2, running stack is n
//    public static boolean PredictTheWinner(int[] nums) {
//        int l=nums.length;
//        int[][] dp=new int[l][l];
//        for(int i=0; i<l; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        return beatByScore(nums, dp, 0, l-1)>=0;
//    }
//
//    private static int beatByScore(int[] nums, int[][] dp, int start, int end) {
//        if(dp[start][end]==-1){
//            dp[start][end]=start==end?nums[start]:Math.max(nums[start]-beatByScore(nums, dp, start+1, end), nums[end]-beatByScore(nums, dp, start, end-1));
//        }
//        return dp[start][end];
//    }

//    // Time complexity： O(2^n) because there're 2^n nodes in the recursion tree
//    // Space complexity: O(1+n) - in-place, running stack is n
//    public boolean PredictTheWinner(int[] nums) {
//        int l=nums.length;
//        return beatByScore(nums, 0, l-1)>=0;
//    }
//
//    private static int beatByScore(int[] nums, int start, int end) {
//        if(start==end){
//            return nums[start];
//        } else{
//            return Math.max(nums[start]-beatByScore(nums, start+1, end), nums[end]-beatByScore(nums, start, end-1));
//        }
//    }

//    public boolean PredictTheWinner(int[] nums) {
//        return canWin(nums, 0, nums.length-1, new int[] {0,0}, 0);
//    }
//
//    // Note the back tracking steps on the score array
//    private boolean canWin(int[] nums, int start, int end, int[] score, int player) {
//        if(start==end) {
//            if(player==0) {
//                return score[player]+nums[start]>=score[player^1];
//            } else {
//                return score[player]+nums[start]>score[player^1];
//            }
//        } else if(start+1==end) {
//            if(player==0) {
//                return score[player]+Math.abs(nums[start]-nums[end])>=score[player^1];
//            } else {
//                return score[player]+Math.abs(nums[start]-nums[end])>score[player^1];
//            }
//        } else {
//            score[player]+=nums[start];
//            if(!canWin(nums, start+1, end, score, player^1)) {
//                score[player]-=nums[start];
//                return true;
//            } else {
//                score[player]-=nums[start];
//                score[player]+=nums[end];
//                if(!canWin(nums, start, end-1, score, player^1)) {
//                    score[player]-=nums[end];
//                    return true;
//                } else {
//                    score[player]-=nums[end];
//                    return false;
//                }
//            }
//        }
//    }
}

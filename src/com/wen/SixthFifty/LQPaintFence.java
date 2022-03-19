package com.wen.SixthFifty;

/*
You are painting a fence of n posts with k different colors. You must paint the posts following these rules:

Every post must be painted exactly one color.
There cannot be three or more consecutive posts with the same color.
Given the two integers n and k, return the number of ways you can paint the fence.

Example 1:
Input: n = 3, k = 2
Output: 6
Explanation: All the possibilities are shown.
Note that painting all the posts red or all the posts green is invalid because there cannot be three posts in a row with the same color.


Example 2:
Input: n = 1, k = 1
Output: 1


Example 3:
Input: n = 7, k = 2
Output: 42


Constraints:
1 <= n <= 50
1 <= k <= 105
The testcases are generated such that the answer is in the range [0, 231 - 1] for the given n and k.
 */

public class LQPaintFence {
    // Optimized dp with no array as no iteration along 1 dimension - the fence idx dimension
    public int numWays(int n, int k) {
        int preDiff=k, preSame=0;
        for(int i=1; i<n; i++){
            int curDiff=(preDiff+preSame)*(k-1);
            int curSame=preDiff;
            preDiff=curDiff;
            preSame=curSame;
        }
        return preDiff+preSame;
    }

//    // DP, bottom up
//    // dp[i][0] stands for the number of ways to paint the post at i to a color different from the previous post,
//    // dp[i][1] stands for the number of ways to paint the post at i to a color same with the previous post
//    public int numWays(int n, int k) {
//        int[][] dp=new int[n][2];
//        for(int i=0; i<n; i++){
//            if(i==0){
//                dp[i][0]=k;
//                dp[i][1]=0;
//            } else{
//                // For a different color, it's the total number of previous ways multiply by (k-1) because current color
//                // can be whichever color except the previous ONE
//                dp[i][0]=(dp[i-1][0]+dp[i-1][1])*(k-1);
//                // For a same color, the previous color can't be the same with the color before it, and it's the same
//                // ONE color
//                dp[i][1]=dp[i-1][0];
//            }
//        }
//        return dp[n-1][0]+dp[n-1][1];
//    }

//    // DP, top down
//    public int numWays(int n, int k) {
//        int[][] memo=new int[n][2];
//        return dp(n, k, n-1, 0, memo)+dp(n, k, n-1, 1, memo);
//    }
//
//    private int dp(int n, int k, int idx, int same, int[][] memo){
//        if(memo[idx][same]==0){
//            if(idx==0){
//                memo[idx][same]=same==1?0:k;
//            } else{
//                if(same==1){
//                    memo[idx][same]=dp(n, k, idx-1, 0, memo);
//                } else{
//                    memo[idx][same]=(dp(n, k, idx-1, 0, memo)+dp(n, k, idx-1, 1, memo))*(k-1);
//                }
//            }
//        }
//        return memo[idx][same];
//    }
}

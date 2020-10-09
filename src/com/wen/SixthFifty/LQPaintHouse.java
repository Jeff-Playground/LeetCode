package com.wen.SixthFifty;

/*

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of
painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses
have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is
the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
             Minimum cost: 2 + 5 + 3 = 10.

 */

public class LQPaintHouse {
    // dp[i][j] stands for the minimum cost to paint the house at i to color j
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0){
            return 0;
        }
        int n=costs.length;
        int[][] dp=new int[n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                if(i==0){
                    dp[i][j]=costs[i][j];
                } else{
                    dp[i][j]=costs[i][j]+Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
                }
            }
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}

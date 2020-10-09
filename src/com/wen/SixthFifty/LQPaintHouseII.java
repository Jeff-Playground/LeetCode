package com.wen.SixthFifty;

/*

There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a
certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is
the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find
the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

 */

public class LQPaintHouseII {
//    // DP, optimized to get rid of dp array
//    public int minCostII(int[][] costs) {
//        if(costs==null || costs.length==0 || costs[0].length==0){
//            return 0;
//        }
//        int n=costs.length, k=costs[0].length;
//        int preMin1=-1, preMin2=-1, preMinColor1=-1;
//        for(int i=0; i<n; i++){
//            int curMin1=Integer.MAX_VALUE, curMin2=Integer.MAX_VALUE, curMinColor1=-1;
//            int cost=-1;
//            for(int j=0; j<k; j++){
//                if(i==0){
//                    cost=costs[i][j];
//                } else{
//                    if(j==preMinColor1){
//                        cost=costs[i][j]+preMin2;
//                    } else{
//                        cost=costs[i][j]+preMin1;
//                    }
//                }
//                if(cost<curMin1){
//                    curMin2=curMin1;
//                    curMin1=cost;
//                    curMinColor1=j;
//                } else if(cost<curMin2){
//                    curMin2=cost;
//                }
//            }
//            preMin1=curMin1;
//            preMin2=curMin2;
//            preMinColor1=curMinColor1;
//        }
//        return preMin1;
//    }

    // DP
    // Note here only need to maintain two min colors from last round, and use those values instead of going over all
    // colors
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0){
            return 0;
        }
        int n=costs.length, k=costs[0].length;
        int[][] dp=new int[n][k];
        int preMinColor1=-1, preMinColor2=-1;
        for(int i=0; i<n; i++){
            int curMinColor1=-1, curMinColor2=-1;
            for(int j=0; j<k; j++){
                if(i==0){
                    dp[i][j]=costs[i][j];
                } else{
                    if(j==preMinColor1){
                        dp[i][j]=costs[i][j]+dp[i-1][preMinColor2];
                    } else{
                        dp[i][j]=costs[i][j]+dp[i-1][preMinColor1];
                    }
                }
                if(curMinColor1==-1 || dp[i][j]<dp[i][curMinColor1]){
                    curMinColor2=curMinColor1;
                    curMinColor1=j;
                } else if(curMinColor2==-1 || dp[i][j]<dp[i][curMinColor2]){
                    curMinColor2=j;
                }
            }
            preMinColor1=curMinColor1;
            preMinColor2=curMinColor2;
        }
        return dp[n-1][preMinColor1];
    }
}

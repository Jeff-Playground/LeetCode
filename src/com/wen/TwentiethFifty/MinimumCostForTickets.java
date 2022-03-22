package com.wen.TwentiethFifty;

import java.util.Arrays;

public class MinimumCostForTickets {
//    // DP1, bottom up
//    // dp[i][j] stands for the minimum cost to travel on day i when buying pass j(note j==n means not buying a pass)
//    public int mincostTickets(int[] days, int[] costs) {
//        int m=days.length, n=costs.length;
//        int[][] dp=new int[m][n+1];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<=n; j++){
//                if(i==0){
//                    dp[i][j]=j<n?costs[j]:Integer.MAX_VALUE;
//                } else{
//                    if(j==n){
//                        dp[i][j]=Integer.MAX_VALUE;
//                        for(int k=i-1; k>=0 && days[k]>days[i]-30; k--){
//                            if(days[k]>days[i]-7){
//                                dp[i][j]=Math.min(dp[i][j], Math.min(dp[k][1], dp[k][2]));
//                            } else if(days[k]>days[i]-30){
//                                dp[i][j]=Math.min(dp[i][j], dp[k][2]);
//                            }
//                        }
//                    } else{
//                        dp[i][j]=Integer.MAX_VALUE;
//                        for(int k=0; k<=n; k++){
//                            dp[i][j]=Math.min(dp[i][j], dp[i-1][k]);
//                        }
//                        dp[i][j]+=costs[j];
//                    }
//                }
//            }
//        }
//        int result=Integer.MAX_VALUE;
//        for(int j=0; j<=n; j++){
//            result=Math.min(result, dp[m-1][j]);
//        }
//        return result;
//    }

//    // DP2, bottom up
//    // dp[i] stands for the minimum cost to travel for day i
//    public int mincostTickets(int[] days, int[] costs) {
//        int l=days.length;
//        int[] dp=new int[l];
//        for(int i=0; i<l; i++){
//            dp[i]=(i-1>=0?dp[i-1]:0)+costs[0];
//            for(int j=i; j>=0 && days[j]>days[i]-30; j--){
//                if(days[j]>days[i]-7){
//                    dp[i]=Math.min(dp[i], (j-1>=0?dp[j-1]:0)+costs[1]);
//                    dp[i]=Math.min(dp[i], (j-1>=0?dp[j-1]:0)+costs[2]);
//                }
//                if(days[j]>days[i]-30){
//                    dp[i]=Math.min(dp[i], (j-1>=0?dp[j-1]:0)+costs[2]);
//                }
//            }
//        }
//        return dp[l-1];
//    }

    // DP2, top down
    public int mincostTickets(int[] days, int[] costs) {
        int l=days.length;
        int[] memo=new int[l+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dp(days, costs, l, memo);
    }

    private int dp(int[] days, int[] costs, int idx, int[] memo){
        if(memo[idx]==Integer.MAX_VALUE){
            if(idx==0){
                memo[idx]=0;
            } else{
                memo[idx]=dp(days, costs, idx-1, memo)+costs[0];
                for(int i=idx; i>=1 && days[i-1]>days[idx-1]-30; i--){
                    if(days[i-1]>days[idx-1]-7){
                        memo[idx]=Math.min(memo[idx], dp(days, costs, i-1, memo)+costs[1]);
                    }
                    if(days[i-1]>days[idx-1]-30){
                        memo[idx]=Math.min(memo[idx], dp(days, costs, i-1, memo)+costs[2]);
                    }
                }
            }
        }
        return memo[idx];
    }
}

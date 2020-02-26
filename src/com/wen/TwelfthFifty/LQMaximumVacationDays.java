package com.wen.TwelfthFifty;

import java.util.Arrays;

public class LQMaximumVacationDays {
    // DP
    // dp[i][j] stands for the max vacation days for week i in city j
    public static int maxVacationDays(int[][] flights, int[][] days) {
        int N=flights.length, K=days[0].length;
        int[][] dp=new int[K][N];
        for(int i=0; i<K; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i=0; i<K; i++){
            for(int j=0; j<N; j++){
                if(i==0){
                    if(j==0){
                        dp[i][j]=days[j][i];
                    } else if(flights[i][j]==1){
                        dp[i][j]=days[j][i];
                    }
                } else {
                    int max=dp[i-1][j];
                    for(int k=0; k<N; k++){
                        if(flights[k][j]==1){
                            max=Math.max(max, dp[i-1][k]);
                        }
                    }
                    dp[i][j]=max==-1?max:days[j][i]+max;
                }
            }
        }
        int result=Integer.MIN_VALUE;
        for(int j=0; j<N; j++){
            result=Math.max(result, dp[K-1][j]);
        }
        return result;
    }
}

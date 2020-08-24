package com.wen.TenthFifty;

public class OnesAndZeroes {
    // DP
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(String str: strs){
            int[] cur=getCounts(str);
            for(int i=m; i>=cur[0]; i--){
                for(int j=n; j>=cur[1]; j--){
                    dp[i][j]=Math.max(dp[i][j], dp[i-cur[0]][j-cur[1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getCounts(String s){
        int[] result=new int[2];
        for(char c: s.toCharArray()){
            result[c-'0']++;
        }
        return result;
    }
}

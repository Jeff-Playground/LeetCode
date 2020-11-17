package com.wen.TwentyThirdFifty;

public class LongestCommonSubsequence {
    // DP, dp[i][j] stands for the longest common subsequence between text1.substring(0,i) and text2.substring(0,j)
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null || text1.length()==0 || text2==null || text2.length()==0) {
            return 0;
        }
        int l1=text1.length(), l2=text2.length();
        int[][] dp=new int[l1+1][l2+1];
        for(int j=1; j<=l2; j++) {
            if(dp[1][j-1]==1) {
                dp[1][j]=1;
            } else {
                if(text1.charAt(0)==text2.charAt(j-1)) {
                    dp[1][j]=1;
                }
            }
        }
        for(int i=1; i<=l1; i++) {
            if(dp[i-1][1]==1) {
                dp[i][1]=1;
            } else {
                if(text1.charAt(i-1)==text2.charAt(0)) {
                    dp[i][1]=1;
                }
            }
        }
        for(int i=2; i<=l1; i++) {
            for(int j=2; j<=l2; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}

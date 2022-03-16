package com.wen.TwentyThirdFifty;

public class LongestCommonSubsequence {
    // DP, top down
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length(), l2=text2.length();
        int[][] cache=new int[l1][l2];
        return dp(text1, text2, cache, l1-1, l2-1);
    }

    private int dp(String text1, String text2, int[][] cache, int i, int j){
        if(cache[i][j]==0){
            if(text1.charAt(i)==text2.charAt(j)){
                cache[i][j]=(i-1<0 || j-1<0)?1:dp(text1, text2, cache, i-1, j-1)+1;
            } else{
                cache[i][j]=Math.max(i-1<0?0:dp(text1, text2, cache, i-1, j), j-1<0?0:dp(text1, text2, cache, i, j-1));
            }
        }
        return cache[i][j];
    }

//    // DP, bottom up
//    // dp[i][j] stands for the longest common subsequence between text1.substring(0,i) and text2.substring(0,j)class Solution {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int l1=text1.length(), l2=text2.length();
//        int[][] dp=new int[l1][l2];
//        for(int i=0; i<l1; i++){
//            if(text1.charAt(i)==text2.charAt(0)){
//                dp[i][0]=1;
//            } else{
//                dp[i][0]=i-1>=0?dp[i-1][0]:0;
//            }
//        }
//        for(int j=0; j<l2; j++){
//            if(text1.charAt(0)==text2.charAt(j)){
//                dp[0][j]=1;
//            } else{
//                dp[0][j]=j-1>=0?dp[0][j-1]:0;
//            }
//        }
//        for(int i=1; i<l1; i++){
//            for(int j=1; j<l2; j++){
//                if(text1.charAt(i)==text2.charAt(j)){
//                    dp[i][j]=dp[i-1][j-1]+1;
//                } else{
//                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[l1-1][l2-1];
//    }
}

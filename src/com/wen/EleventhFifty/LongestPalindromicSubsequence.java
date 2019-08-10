package com.wen.EleventhFifty;

import java.util.Collections;

public class LongestPalindromicSubsequence {
//    // dp stands for the longest palindromic subsequence for s.substring(i, j+1)
//    public int longestPalindromeSubseq(String s) {
//        int result=0;
//        if(s==null || s.length()==0){
//            return result;
//        }
//        int[][] dp=new int[s.length()][s.length()];
//        for(int j=0; j<s.length(); j++){
//            for(int i=j; i>=0; i--){
//                if(i==j){
//                    dp[i][j]=1;
//                } else if(i+1==j){
//                    dp[i][j]=s.charAt(i)==s.charAt(j)?2:1;
//                } else{
//                    if(s.charAt(i)==s.charAt(j)){
//                        dp[i][j]=dp[i+1][j-1]+2;
//                    } else{
//                        dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
//                    }
//                }
//            }
//        }
//        return dp[0][s.length()-1];
//    }

    // This problem can be converted to find the largest common subsequence for s and StringBuilder(s).reverse().toString();
    public static int longestPalindromeSubseq(String s) {
        int result=0;
        if(s==null || s.length()==0){
            return result;
        }
        String sr= new StringBuilder(s).reverse().toString();
        int l=s.length();
        int[][] dp=new int[l][l];
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(i==0){
                    if(s.charAt(i)==sr.charAt(j)){
                        dp[i][j]=1;
                    } else{
                        dp[i][j]=j>0?dp[i][j-1]:0;
                    }
                }else if(j==0){
                    if(s.charAt(i)==sr.charAt(j)){
                        dp[i][j]=1;
                    } else{
                        dp[i][j]=i>0?dp[i-1][j]:0;
                    }
                } else{
                    if(s.charAt(i)==sr.charAt(j)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    } else{
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[l-1][l-1];
    }
}

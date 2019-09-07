package com.wen.FirstFifty;

import java.util.Arrays;

public class RegularExpressionMatching {
    // Dynamic Programming
    public static boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(j>1 && p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2] || (i>0 && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') && dp[i-1][j]);
                } else if(i>0 && j>0){
                    dp[i][j]=dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
                }
            }
        }
        return dp[m][n];
    }

    // Recursion
//    public boolean isMatch(String s, String p) {
//        // Check p for emptiness because empty s can match to a p like "a*"
//        if(p.isEmpty()) {
//            return s.isEmpty();
//        }
//        if(p.length()>1 && p.charAt(1)=='*') {
//            return isMatch(s,p.substring(2)) || (!s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && isMatch(s.substring(1),p));
//        } else {
//            return !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && isMatch(s.substring(1), p.substring(1));
//        }
//    }
}

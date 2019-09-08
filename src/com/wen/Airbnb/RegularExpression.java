package com.wen.Airbnb;

public class RegularExpression {
//    public boolean regMatch(String s, String p) {
//        if(p.isEmpty()){
//            return s.isEmpty();
//        }
//        if(p.length()>1 && p.charAt(1)=='*'){
//            return (!s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && regMatch(s.substring(1), p)) || regMatch(s, p.substring(2));
//        } else if(p.length()>1 && p.charAt(1)=='+'){
//            return !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && (regMatch(s.substring(1), p) || regMatch(s.substring(1), p.substring(2)));
//        } else{
//            return !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && regMatch(s.substring(1), p.substring(1));
//        }
//    }

    public boolean regMatch(String s, String p) {
        int m=s.length(), n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j-1>0 && p.charAt(j-1)=='*'){
                    dp[i][j]=(i-1>=0 && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') && dp[i-1][j]) || dp[i][j-2];
                } else if(j-1>0 && p.charAt(j-1)=='+'){
                    dp[i][j]=i-1>=0 && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') && (dp[i-1][j] || dp[i-1][j-2]);
                } else if(i>0 && j>0){
                    dp[i][j]=dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
                }
            }
        }
        return dp[m][n];
    }
}

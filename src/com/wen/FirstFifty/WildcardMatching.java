package com.wen.FirstFifty;

public class WildcardMatching {
//    public static boolean isMatch(String s, String p) {
//        int m=s.length(), n=p.length();
//        int sStar=-1, sCur=0;
//        int pStar=-1, pCur=0;
//        while(sCur<m) {
//            if(pCur<p.length() && (p.charAt(pCur)=='?' || p.charAt(pCur)==s.charAt(sCur))) {
//                pCur++;
//                sCur++;
//            } else if(pCur<p.length() && p.charAt(pCur)=='*') {
//                pStar=pCur;
//                sStar=sCur;
//                pCur++;
//            } else if(pStar!=-1) {
//                pCur=pStar+1;
//                sCur=++sStar;
//            } else {
//                return false;
//            }
//        }
//        while(pCur<p.length() && p.charAt(pCur)=='*') {
//            pCur++;
//        }
//        return pCur==p.length();
//    }

    // Dynamic Programming
    public static boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i-1>=0 && j-1>=0 && (p.charAt(j-1)=='?' || s.charAt(i-1)==p.charAt(j-1))) {
                    dp[i][j]=dp[i-1][j-1];
                }else if(j-1>=0 && p.charAt(j-1)=='*') {
                    dp[i][j]=(i-1>=0 && dp[i-1][j]) || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}

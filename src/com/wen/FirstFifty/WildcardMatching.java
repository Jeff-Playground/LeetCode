package com.wen.FirstFifty;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        int sStar=-1, sCur=0;
        int pStar=-1, pCur=0;
        while(sCur<m) {
            if(pCur<p.length() && (p.charAt(pCur)=='?' || p.charAt(pCur)==s.charAt(sCur))) {
                pCur++;
                sCur++;
            } else if(pCur<p.length() && p.charAt(pCur)=='*') {
                pStar=pCur;
                sStar=sCur;
                pCur++;
            } else if(pStar!=-1) {
                pCur=pStar+1;
                sCur=++sStar;
            } else {
                return false;
            }
        }
        while(pCur<p.length() && p.charAt(pCur)=='*') {
            pCur++;
        }
        return pCur==p.length();
    }

//    // Dynamic Programming
//    public boolean isMatch(String s, String p) {
//        int m=s.length(), n=p.length();
//        boolean[][] flags=new boolean[m+1][n+1];
//        flags[0][0]=true;
//        for(int i=1; i<=n; i++) {
//            if(p.charAt(i-1)=='*') {
//                flags[0][i]=flags[0][i-1];
//            }
//        }
//        for(int i=1; i<=m; i++) {
//            for(int j=1; j<=n; j++) {
//                if(p.charAt(j-1)=='?') {
//                    flags[i][j]=flags[i-1][j-1];
//                }else if(p.charAt(j-1)=='*') {
//                    flags[i][j]=flags[i-1][j] || flags[i][j-1];
//                }else {
//                    flags[i][j]=flags[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1));
//                }
//            }
//        }
//        return flags[m][n];
//    }
}

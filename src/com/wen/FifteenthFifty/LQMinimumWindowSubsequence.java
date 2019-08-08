package com.wen.FifteenthFifty;

import java.util.Arrays;

public class LQMinimumWindowSubsequence {
    public static String minWindow(String S, String T) {
        int m=S.length(), n=T.length();
        int left=0, right=0, is=0, it=0, length=m+1;
        while(is<m){
            if(S.charAt(is)==T.charAt(it)){
                if(++it==n){
                    right=is;
                    while(--it>=0){
                        while(S.charAt(is--)!=T.charAt(it)){

                        }
                    }
                    is++;
                    it++;
                    if(right-is+1<length){
                        length=right-is+1;
                        left=is;
                    }
                }
            }
            is++;
        }
        return length==m+1?"":S.substring(left, left+length);
    }

//    // DP
//    public String minWindow(String S, String T) {
//        int m=S.length(), n=T.length();
//        int[][] dp=new int[m][n];
//        for(int i=0; i<m; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        for(int i=0; i<m; i++){
//            if(S.charAt(i)==T.charAt(0)){
//                dp[i][0]=i;
//            } else{
//                if(i==0){
//                    dp[i][0]=-1;
//                } else{
//                    dp[i][0]=dp[i-1][0];
//                }
//            }
//        }
//        int start=-1, length=m+1;
//        for(int j=1; j<n; j++){
//            for(int i=j; i<m; i++){
//                if(S.charAt(i)==T.charAt(j)){
//                    dp[i][j]=dp[i-1][j-1];
//                } else{
//                    if(i==j){
//                        dp[i][j]=-1;
//                    } else{
//                        dp[i][j]=dp[i-1][j];
//                    }
//                }
//                if(j==n-1 && dp[i][j]>=0){
//                    if(i-dp[i][j]+1<length){
//                        length=i-dp[i][j]+1;
//                        start=dp[i][j];
//                    }
//                }
//            }
//        }
//        return start==-1?"":S.substring(start, start+length);
//    }
}

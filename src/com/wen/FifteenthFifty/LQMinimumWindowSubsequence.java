package com.wen.FifteenthFifty;

import java.util.Arrays;

public class LQMinimumWindowSubsequence {
//    // Greedy, iterate over S and find a match, then iterate reversely to find the left point(it's not necessarily the
//    // first match in the original iteration, consider S=aaab and T=ab). Once found a match, update the minimum window
//    // if applicable
//    public static String minWindow(String S, String T) {
//        int m=S.length(), n=T.length();
//        int left=0, right=0, si=0, ti=0, minLength=m+1;
//        while(si<m){
//            if(S.charAt(si)==T.charAt(ti)){
//                if(++ti==n){
//                    right=si;
//                    ti--;
//                    while(ti>=0){
//                        if(S.charAt(si)==T.charAt(ti)){
//                            ti--;
//                        }
//                        si--;
//                    }
//                    if(right-si+1<minLength){
//                        left=si+1;
//                        minLength=right-left+1;
//                    }
//                    ti++;
//                    si++;
//                }
//            }
//            si++;
//        }
//        if(minLength<m+1){
//            return S.substring(left, left+minLength);
//        } else{
//            return "";
//        }
//    }

    // DP
    // dp[i][j] stands for the index of the starting char where S.substring(0, i+1) contains a subsequence of
    // T.substring(0, j+1)
    public static String minWindow(String S, String T) {
        int m=S.length(), n=T.length();
        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i=0; i<m; i++){
            if(S.charAt(i)==T.charAt(0)){
                dp[i][0]=i;
            } else{
                if(i==0){
                    dp[i][0]=-1;
                } else{
                    dp[i][0]=dp[i-1][0];
                }
            }
        }
        int start=-1, length=m+1;
        for(int j=1; j<n; j++){
            for(int i=j; i<m; i++){
                if(S.charAt(i)==T.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                    if(j==n-1 && dp[i][j]>=0){
                        if(i-dp[i][j]+1<length){
                            length=i-dp[i][j]+1;
                            start=dp[i][j];
                        }
                    }
                } else{
                    if(i==j){
                        dp[i][j]=-1;
                    } else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        return start==-1?"":S.substring(start, start+length);
    }
}

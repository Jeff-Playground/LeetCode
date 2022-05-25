package com.wen.FourteenthFifty;

public class StrangePrinter {
    // DP, bottom up, dp[i][j] stands for the minimum number of turns to print s.substring(i, j+1)
    // dp[i][j]=Math.min(dp[i][j], dp[i+1][k-1]+dp[k][j]) for s.charAt(i)==s.charAt(k) because char at i can be printed in one turn for dp[k][j]
    public int strangePrinter(String s) {
        int len=s.length();
        int[][] dp=new int[len][len];
        for(int l=1; l<=len; l++){
            for(int i=0; i+l-1<len; i++){
                int j=i+l-1;
                if(i==j){
                    dp[i][j]=1;
                } else{
                    dp[i][j]=dp[i+1][j]+1;
                    for(int k=i+1; k<=j; k++){
                        if(s.charAt(i)==s.charAt(k)){
                            dp[i][j]=Math.min(dp[i][j], dp[i+1][k-1]+dp[k][j]);
                        }
                    }
                }
            }
        }
        return dp[0][len-1];
    }

//    // DP, top down
//    public int strangePrinter(String s) {
//        int l=s.length();
//        int[][] memo=new int[l][l];
//        return spHelper(s, 0, l-1, memo);
//    }
//
//    private int spHelper(String s, int start, int end, int[][] memo){
//        if(start>end){
//            return 0;
//        } else{
//            if(memo[start][end]==0){
//                if(start==end){
//                    memo[start][end]=1;
//                } else{
//                    memo[start][end]=spHelper(s, start+1, end, memo)+1;
//                    for(int i=start+1; i<=end; i++){
//                        if(s.charAt(i)==s.charAt(start)){
//                            memo[start][end]=Math.min(memo[start][end], spHelper(s, start+1, i-1, memo)+spHelper(s, i, end, memo));
//                        }
//                    }
//                }
//            }
//            return memo[start][end];
//        }
//    }
}
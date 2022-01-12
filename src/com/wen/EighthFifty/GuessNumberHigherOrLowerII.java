package com.wen.EighthFifty;

public class GuessNumberHigherOrLowerII {
    // DP, minimax iteratively, dp[i][j] stands for the minimum money required for guessing in range [i,j]
    public static int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        // When l==1, there's only 1 number, no guessing needed, so required money is 0
        for(int l=2; l<=n; l++){
            for(int i=1; i<=n; i++){
                if(i+l-1<=n){
                    if(l==2){
                        dp[i][i+l-1]=i;
                    } else if(l==3){
                        dp[i][i+l-1]=i+1;
                    } else{
                        dp[i][i+l-1]=Math.min(i+dp[i+1][i+l-1], i+l-1+dp[i][i+l-2]);
                        for(int j=i+1; j<i+l-1; j++){
                            dp[i][i+l-1]=Math.min(dp[i][i+l-1], j+Math.max(dp[i][j-1], dp[j+1][i+l-1]));
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }

//    // DP, minimax recursively, dp[i][j] stands for the minimum money required for guessing in range [i,j]
//    public static int getMoneyAmount(int n) {
//        int[][] dp=new int[n+1][n+1];
//        return gmaHelper(1, n, dp);
//    }
//
//    private static int gmaHelper(int start, int end, int[][] dp){
//        if(start>=end){
//            return 0;
//        }
//        if(dp[start][end]>0){
//            return dp[start][end];
//        }
//        dp[start][end]=Integer.MAX_VALUE;
//        for(int i=start; i<=end; i++){
//            dp[start][end]=Math.min(dp[start][end], i+Math.max(gmaHelper(start, i-1, dp), gmaHelper(i+1, end, dp)));
//        }
//        return dp[start][end];
//    }
}

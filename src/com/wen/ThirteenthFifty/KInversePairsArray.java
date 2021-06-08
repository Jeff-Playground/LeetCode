package com.wen.ThirteenthFifty;

public class KInversePairsArray {
    // Optimize below DP by doing dp[n][k]-dp[n][k-1] and got dp[n][k]-dp[n][k-1]=dp[n-1][k]-dp[(k-1)-(n-1)]
    // When k-1<n-1, dp[(k-1)-(n-1)]=0, so the calculation is highly optimized
    public int kInversePairs(int n, int k) {
        if(k>n*(n-1)/2){
            return 0;
        }
        int mod=1_000_000_007;
        int[][] dp=new int[n+1][k+1];
        for(int i=0; i<=n; i++){
            dp[i][0]=1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k && j<=i*(i-1)/2; j++){
                dp[i][j]=(dp[i][j-1]+dp[i-1][j])%mod;
                if(i-1<=j-1){
                    dp[i][j]=(mod+dp[i][j]-dp[i-1][(j-1)-(i-1)])%mod;
                }
            }
        }
        return dp[n][k];
    }

//    // DP, dp[n][k]=dp[n-1][k]+dp[n-1][k-1]+...+dp[n-1][k-(n-1)] when k-(n-1)>=0, otherwise it should be
//    // to dp[n-1][0]
//    // Note for n, the maximum of k is n*(n-1)/2 when the full array is reversed
//    public int kInversePairs(int n, int k) {
//        if(k>n*(n-1)/2){
//            return 0;
//        }
//        int mod=1_000_000_007;
//        int[][] dp=new int[n+1][k+1];
//        dp[0][0]=1;
//        for(int i=1; i<=n; i++){
//            for(int j=0; j<=k && j<=i*(i-1)/2; j++){
//                for(int t=0; t<=i-1 && t<=j; t++){
//                    dp[i][j]=(dp[i][j]+dp[i-1][j-t])%mod;
//                }
//            }
//        }
//        return dp[n][k];
//    }
}

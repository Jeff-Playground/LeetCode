package com.wen.SecondFifty;

public class UniqueBinarySearchTrees {
    // Mathematical Deduction method based on Catalan number(proof by geometry)
    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

//    // Dynamic Programming: Result is a Catalan number
//    public int numTrees(int n) {
//        int[] dp=new int[n+1];
//        dp[0]=1;
//        dp[1]=1;
//        for(int i=2; i<=n; i++){
//            for(int j=0; j<i; j++){
//                dp[i]+=dp[j]*dp[i-j-1];
//            }
//        }
//        return dp[n];
//    }
}

package com.wen.SecondFifty;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
//    // Mathematical Deduction method based on Catalan number(proof by geometry)
//    public int numTrees(int n) {
//        // Note: we should use long here instead of int, otherwise overflow
//        long C = 1;
//        for (int i = 0; i < n; ++i) {
//            C = C * 2 * (2 * i + 1) / (i + 2);
//        }
//        return (int) C;
//    }

//    // Dynamic Programming: Result is a Catalan number
//    // dp[i] stands for the number of unique binary search trees for i nodes
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

    // Divide and conquer, similar to dp and using knownCounts Map to avoid duplicated calculations
    public int numTrees(int n) {
        Map<Integer, Integer> knownCounts=new HashMap<>();
        knownCounts.put(0, 1);
        knownCounts.put(1, 1);
        numTreesHelper(n, knownCounts);
        return knownCounts.get(n);
    }

    public int numTreesHelper(int n, Map<Integer, Integer> knownCounts) {
        if(knownCounts.containsKey(n)){
            return knownCounts.get(n);
        }
        int result=0;
        for(int i=1; i<=n; i++){
            int left=numTreesHelper(i-1, knownCounts);
            int right=numTreesHelper(n-i, knownCounts);
            result+=left*right;
        }
        knownCounts.put(n, result);
        return result;
    }
}

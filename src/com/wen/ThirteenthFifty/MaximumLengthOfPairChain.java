package com.wen.ThirteenthFifty;

import java.util.Arrays;
import java.util.Collections;

public class MaximumLengthOfPairChain {
    // DP
    public int findLongestChain(int[][] pairs) {
        int result=1;
        Arrays.sort(pairs, (a, b)->a[0]-b[0]);
        int l=pairs.length;
        int[] dp=new int[l];
        Arrays.fill(dp, 1);
        for(int j=1; j<l; j++){
            for(int i=0; i<j; i++){
                if(pairs[i][1]<pairs[j][0]){
                    dp[j]=Math.max(dp[j], dp[i]+1);
                    result=Math.max(result, dp[j]);
                }
            }
        }
        return result;
    }

//    // Greedy algorithm
//    public int findLongestChain(int[][] pairs) {
//        int count=1;
//        Arrays.sort(pairs, (a, b)->a[1]-b[1]);
//        int end=pairs[0][1];
//        for(int i=1; i<pairs.length; i++){
//            if(pairs[i][0]>end){
//                count++;
//                end=pairs[i][1];
//            }
//        }
//        return count;
//    }
}

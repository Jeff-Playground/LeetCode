package com.wen.SeventeenthFifty;

import java.util.*;

public class SplitArrayWithSameAverage {
    // Similar to knapsack
    public boolean splitArraySameAverage(int[] A) {
        if(A==null || A.length<2){
            return false;
        }
        int l=A.length, max=l/2, sum=0;
        for(int num: A){
            sum+=num;
        }
        boolean possible=false;
        for(int i=1; !possible && i<=max; i++){
            if(sum*i%l==0){
                possible=true;
            }
        }
        if(possible){
            boolean[][] dp=new boolean[max+1][sum+1];
            dp[0][0]=true;
            for(int num: A){
                // Note here i had to be reversed to avoid same number used twice
                for(int i=max; i>=1; i--){
                    for(int j=num; j<=sum; j++){
                        dp[i][j]=dp[i][j] || dp[i-1][j-num];
                    }
                }
            }
            for(int i=1; i<=max; i++){
                if(sum*i%l==0 && dp[i][sum*i/l]){
                    return true;
                }
            }
        }
        return false;
    }

//    public static boolean splitArraySameAverage(int[] A) {
//        if(A==null || A.length<2){
//            return false;
//        }
//        int l=A.length, max=l/2, sum=0;
//        for(int num: A){
//            sum+=num;
//        }
//        boolean possible=false;
//        for(int i=1; !possible && i<=max; i++){
//            if(sum*i%l==0){
//                possible=true;
//            }
//        }
//        if(possible){
//            Map<Integer, Set<Integer>> dp=new HashMap<>();
//            dp.put(0,new HashSet<>(Arrays.asList(0)));
//            for(int i=1; i<=max; i++){
//                dp.put(i, new HashSet<>());
//            }
//            for(int num: A){
//                for(int i=max; i>=1; i--){
//                    for(int pre: dp.get(i-1)){
//                        dp.get(i).add(pre+num);
//                    }
//                }
//            }
//            for(int i=1; i<=max; i++){
//                if(sum*i%l==0 && dp.get(i).contains(sum*i/l)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}

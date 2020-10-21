package com.wen.TwelfthFifty;

import java.util.HashMap;
import java.util.Map;

public class DeleteOperationForTwoStrings {
//    // DP1, dp[i][j] stands for the minimum distance between word1.substring(0, i) and word2.substring(0, j)
//    public int minDistance(String word1, String word2) {
//        int l1=word1.length(), l2=word2.length();
//        int[][] dp=new int[l1+1][l2+1];
//        for(int i=1; i<=l1; i++){
//            dp[i][0]=i;
//        }
//        for(int j=1; j<=l2; j++){
//            dp[0][j]=j;
//        }
//        for(int i=1; i<=l1; i++){
//            for(int j=1; j<=l2; j++){
//                if(word1.charAt(i-1)==word2.charAt(j-1)){
//                    dp[i][j]=dp[i-1][j-1];
//                } else{
//                    dp[i][j]=1+Math.min(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[l1][l2];
//    }

//    // DP2, dp[i][j] stands for the longest common subsequence of word1.substring(0, i+1) and word2.substring(0, j+1)
//    public int minDistance(String word1, String word2) {
//        int l1=word1.length(), l2=word2.length();
//        if(l1==0 || l2==0){
//            return l1==0?l2:l1;
//        }
//        int[][] dp=new int[l1][l2];
//        for(int i=0; i<l1; i++){
//            for(int j=0; j<l2; j++){
//                if(word1.charAt(i)==word2.charAt(j)){
//                    if(i-1>=0 && j-1>=0){
//                        dp[i][j]=dp[i-1][j-1]+1;
//                    } else{
//                        dp[i][j]=1;
//                    }
//                } else{
//                    dp[i][j]=Math.max(i>0?dp[i-1][j]:0, j>0?dp[i][j-1]:0);
//                }
//            }
//        }
//        return l1+l2-2*dp[l1-1][l2-1];
//    }

    // Similar to DP1 but done recursively with a memo Map to avoid TLE
    public int minDistance(String word1, String word2) {
        int l1=word1.length(), l2=word2.length();
        Map<Integer, Integer> memo=new HashMap<>();
        return mdHelper(word1, word2, l1, l2, memo);
    }

    private int mdHelper(String word1, String word2, int cl1, int cl2, Map<Integer, Integer> memo){
        int l1=word1.length(), l2=word2.length();
        int key=cl1*(l2+1)+cl2;
        if(!memo.containsKey(key)){
            if(cl1==0 || cl2==0){
                memo.put(key, cl1==0?cl2:cl1);
            } else{
                if(word1.charAt(cl1-1)==word2.charAt(cl2-1)){
                    memo.put(key, mdHelper(word1, word2, cl1-1, cl2-1, memo));
                } else{
                    memo.put(key, 1+Math.min(mdHelper(word1, word2, cl1-1, cl2, memo), mdHelper(word1, word2, cl1, cl2-1, memo)));
                }
            }
        }
        return memo.get(key);
    }
}

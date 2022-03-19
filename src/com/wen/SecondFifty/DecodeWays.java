package com.wen.SecondFifty;

import java.util.Arrays;

public class DecodeWays {
    public static int numDecodings(String s) {
        if(s==null || s.length()==0 || s.startsWith("0")){
            return 0;
        }
        int curCount=1, beforeCount=1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                curCount=0;
            }
            if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && (s.charAt(i)>='0' && s.charAt(i)<='6'))){
                curCount=curCount+beforeCount;
                beforeCount=curCount-beforeCount;
            } else {
                beforeCount=curCount;
            }
        }
        return curCount;
    }

//    // DP, bottom up
//    // dp[i] stands for the number of decoding ways for s.substring(0, i+1)
//    public static int numDecodings(String s) {
//        if(s==null || s.length()==0){
//            return 0;
//        }
//        int[] dp=new int[s.length()+1];
//        dp[0]=1;
//        if(s.charAt(0)=='0'){
//            return 0;
//        } else{
//            dp[1]=1;
//        }
//        for(int i=1; i<s.length(); i++){
//            // when the added char is treated as a single char
//            if(s.charAt(i)>='1' && s.charAt(i)<='9'){
//                dp[i+1]=dp[i];
//            } else{
//                dp[i+1]=0;
//            }
//            // when the added char can be combined with the previous char
//            if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2'&& (s.charAt(i)>='0' && s.charAt(i)<='6'))){
//                dp[i+1]=dp[i+1]+dp[i-1];
//            }
//        }
//        return dp[s.length()];
//    }

//    // DP, top down
//    public int numDecodings(String s) {
//        int l=s.length();
//        int[] memo=new int[l];
//        Arrays.fill(memo, -1);
//        return dp(s, l-1, memo);
//    }
//
//    private int dp(String s, int idx, int[] memo){
//        if(memo[idx]==-1){
//            if(idx==0){
//                memo[idx]=s.charAt(0)=='0'?0:1;
//            } else{
//                if(s.charAt(idx)=='0'){
//                    if(s.charAt(idx-1)<'1' || s.charAt(idx-1)>'2'){
//                        memo[idx]=0;
//                    } else{
//                        memo[idx]=idx-2>=0?dp(s, idx-2, memo):1;
//                    }
//                } else{
//                    memo[idx]=dp(s, idx-1, memo);
//                    if(s.charAt(idx-1)=='1' || (s.charAt(idx)<'7' && s.charAt(idx-1)=='2')){
//                        memo[idx]+=idx-2>=0?dp(s, idx-2, memo):1;
//                    }
//                }
//            }
//        }
//        return memo[idx];
//    }
}

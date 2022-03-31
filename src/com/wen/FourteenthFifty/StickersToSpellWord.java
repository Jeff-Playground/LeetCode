package com.wen.FourteenthFifty;

import java.util.Arrays;

public class StickersToSpellWord {
//    // DP(bottom up) and bit manipulation
//    // dp[i] stands for the minimum stickers required to form the subsequence of target, where i is used as a bit tracker
//    // to denote whether a certain index of target is present or not(1 is present and 0 is not)
//    public int minStickers(String[] stickers, String target) {
//        int l=target.length();
//        int[] dp=new int[(int)Math.pow(2, l)];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0]=0;
//        for(int i=0; i<dp.length; i++){
//            // dp[i]==Integer.MAX_VALUE means it's a subsequence that can not be formed, so skip it as it can not be used
//            // as a starting point
//            if(dp[i]!=Integer.MAX_VALUE){
//                for(String s: stickers){
//                    int cur=i;
//                    for(char c: s.toCharArray()){
//                        for(int j=0; j<l; j++){
//                            if(target.charAt(j)==c && ((cur>>j)&1)==0){
//                                cur|=1<<j;
//                                // break because the char can only be used once
//                                break;
//                            }
//                        }
//                    }
//                    dp[cur]=Math.min(dp[cur], dp[i]+1);
//                }
//            }
//        }
//        return dp[dp.length-1]<Integer.MAX_VALUE?dp[dp.length-1]:-1;
//    }

    // DP, top down
    public int minStickers(String[] stickers, String target) {
        int l=target.length();
        int[] memo=new int[1<<l];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dp(stickers, target, (1<<l)-1, memo);
    }

    private int dp(String[] stickers, String target, int idx, int[] memo){
        if(memo[idx]==Integer.MAX_VALUE){
            if(idx==0){
                memo[idx]=0;
            } else{
                for(String s: stickers){
                    int cur=idx;
                    for(char c: s.toCharArray()){
                        for(int i=0; i<target.length(); i++){
                            if(target.charAt(i)==c && ((cur>>i)&1)==1){
                                cur&=~(1<<i);
                                break;
                            }
                        }
                    }
                    // this if condition is the equivalent to if(dp[i]!=Integer.MAX_VALUE) in bottom up, otherwise there
                    // could be a stackoverflow due to infinite loop
                    if(cur!=idx){
                        int last=dp(stickers, target, cur, memo);
                        if(last!=-1){
                            memo[idx]=Math.min(memo[idx], last+1);
                        }
                    }
                }
                memo[idx]=memo[idx]==Integer.MAX_VALUE?-1:memo[idx];
            }
        }
        return memo[idx];
    }
}

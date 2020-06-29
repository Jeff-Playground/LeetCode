package com.wen.EighthFifty;

import java.util.*;
import java.util.stream.Collectors;

public class RussianDollEnvelopes {
    // Binary search similar to LongestIncreasingSubsequence
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes, (a, b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        List<Integer> dp=new ArrayList<>();
        int l=envelopes.length;
        for(int i=0; i<l; i++){
            int left=0, right=dp.size(), h=envelopes[i][1];
            while(left<right){
                int mid=left+(right-left)/2;
                if(dp.get(mid)<h){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            if(right>=dp.size()){
                dp.add(h);
            } else{
                dp.set(right, h);
            }
        }
        return dp.size();
    }

//    public int maxEnvelopes(int[][] envelopes) {
//        if(envelopes==null || envelopes.length==0){
//            return 0;
//        }
//        int l=envelopes.length;
//        Arrays.sort(envelopes, (a, b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
//        int[] dp=new int[l];
//        for(int i=0; i<l; i++){
//            dp[i]=1;
//            for(int j=i-1; j>=0; j--){
//                if(biggerThan(envelopes[i], envelopes[j])){
//                    dp[i]=Math.max(dp[i], dp[j]+1);
//                }
//            }
//        }
//        int result=0;
//        for(int i=0; i<l; i++){
//            result=Math.max(result, dp[i]);
//        }
//        return result;
//    }
//
//    private boolean biggerThan(int[] envelope1, int[] envelope2) {
//        return envelope1[0]>envelope2[0] && envelope1[1]>envelope2[1];
//    }
}

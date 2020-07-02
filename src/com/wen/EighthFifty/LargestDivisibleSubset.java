package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    // DP2
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int l=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[l];
        int[] child=new int[l];
        int max=0, maxIdx=0;
        for(int i=0; i<l; i++){
            for(int j=i; j>=0; j--){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    child[i]=j;
                    if(dp[i]>max){
                        max=dp[i];
                        maxIdx=i;
                    }
                }
            }
        }
        for(int i=0; i<max; i++){
            result.add(0, nums[maxIdx]);
            maxIdx=child[maxIdx];
        }
        return result;
    }

//    // DP1
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        int l=nums.length;
//        Arrays.sort(nums);
//        int[] dp=new int[l];
//        int[] parent=new int[l];
//        int max=0, maxIdx=0;
//        for(int i=l-1; i>=0; i--){
//            for(int j=i; j<l; j++){
//                if(nums[j]%nums[i]==0 && dp[i]<dp[j]+1){
//                    dp[i]=dp[j]+1;
//                    parent[i]=j;
//                    if(dp[i]>max){
//                        max=dp[i];
//                        maxIdx=i;
//                    }
//                }
//            }
//        }
//        for(int i=0; i<max; i++){
//            result.add(nums[maxIdx]);
//            maxIdx=parent[maxIdx];
//        }
//        return result;
//    }
}

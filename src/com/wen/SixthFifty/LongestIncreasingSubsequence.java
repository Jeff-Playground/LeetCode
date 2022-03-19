package com.wen.SixthFifty;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
//    // Binary search2, similar to bs1 written in a different manner
//    public int lengthOfLIS(int[] nums) {
//        int l=nums.length;
//        int[] seq=new int[l];
//        int size=0;
//        for(int i=0; i<l; i++){
//            int left=0, right=size;
//            while(left<right){
//                int mid=left+(right-left)/2;
//                if(seq[mid]<nums[i]){
//                    left=mid+1;
//                } else{
//                    right=mid;
//                }
//            }
//            if(right==size){
//                seq[size++]=nums[i];
//            } else{
//                seq[right]=nums[i];
//            }
//        }
//        return size;
//    }

//    // Binary search1
//    public int lengthOfLIS(int[] nums) {
//        int l=nums.length;
//        int[] seq=new int[l];
//        int index=-1;
//        for(int i=0; i<l; i++){
//            if(index==-1 || nums[i]>seq[index]){
//                seq[++index]=nums[i];
//            } else{
//                // Note this replace would help to replace the last element of seq to a smaller value, if it's not
//                // updating the last element, then it doesn't hurt. Only the eventual seq is not necessarily a valid
//                // seq. Even if it's not replacing the last element, it helps when later some other number can replace
//                // the last element.
//                int left=0, right=index;
//                while(left<right){
//                    int mid=left+(right-left)/2;
//                    if(seq[mid]<nums[i]){
//                        left=mid+1;
//                    } else{
//                        right=mid;
//                    }
//                }
//                seq[right]=nums[i];
//            }
//        }
//        return index+1;
//    }

    // DP, bottom up
    // dp[i] stands for the length of LIS before nums[i]
    public int lengthOfLIS(int[] nums) {
        int result=0;
        int l=nums.length;
        int[] dp=new int[l];
        Arrays.fill(dp, 1);
        for(int i=0; i<l; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            result=Math.max(result, dp[i]);
        }
        return result;
    }

//    // DP, top down
//    public int lengthOfLIS(int[] nums) {
//        int l=nums.length;
//        int[] memo=new int[l];
//        int result=0;
//        for(int i=0; i<l; i++){
//            dp(nums, i, memo);
//            result=Math.max(result, memo[i]);
//        }
//        return result;
//    }
//
//    private int dp(int[] nums, int idx, int[] memo){
//        if(memo[idx]==0){
//            if(idx==0){
//                memo[idx]=1;
//            } else{
//                int max=1;
//                for(int i=0; i<idx; i++){
//                    if(nums[idx]>nums[i]){
//                        max=Math.max(dp(nums, i, memo)+1, max);
//                    }
//                }
//                memo[idx]=max;
//            }
//        }
//        return memo[idx];
//    }
}

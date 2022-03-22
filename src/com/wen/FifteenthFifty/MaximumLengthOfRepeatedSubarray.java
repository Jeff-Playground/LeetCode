package com.wen.FifteenthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumLengthOfRepeatedSubarray {
    // DP, bottom up
    // dp[i][j] stands for the length of repeated subarray at the end of the arrays for nums1 ends at i and nums2 ends at j
    public int findLength(int[] nums1, int[] nums2) {
        int l1=nums1.length, l2=nums2.length, result=0;
        int[][] dp=new int[l1][l2];
        for(int i=0; i<l1; i++){
            for(int j=0; j<l2; j++){
                if(nums1[i]==nums2[j]){
                    if(i-1>=0 && j-1>=0 && dp[i-1][j-1]>0){
                        dp[i][j]=dp[i-1][j-1]+1;
                    } else{
                        dp[i][j]=1;
                    }
                    result=Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

//    // DP, top down
//    public int findLength(int[] nums1, int[] nums2) {
//        int m=nums1.length, n=nums2.length;
//        int[][] memo=new int[m][n];
//        int[] result=new int[]{0};
//        for(int[] v: memo){
//            Arrays.fill(v, -1);
//        }
//        dp(nums1, nums2, m-1, n-1, memo, result);
//        return result[0];
//    }
//
//    private int dp(int[] nums1, int[] nums2, int i, int j, int[][] memo, int[] result){
//        if(memo[i][j]==-1){
//            if(i==0 || j==0){
//                memo[i][j]=nums1[i]==nums2[j]?1:0;
//            } else{
//                if(nums1[i]==nums2[j]){
//                    memo[i][j]=dp(nums1, nums2, i-1, j-1, memo, result)+1;
//                } else{
//                    memo[i][j]=0;
//                }
//                dp(nums1, nums2, i-1, j, memo, result);
//                dp(nums1, nums2, i, j-1, memo, result);
//            }
//        }
//        result[0]=Math.max(result[0], memo[i][j]);
//        return memo[i][j];
//    }

//    // Binary search, note the [low, high] range here is the range for the number which is result+1, this is to avoid
//    // low=mid which could end in a infinite loop
//    // Also note because the numbers in the given arrays are in [0,100], which is within the ASCII, so we can make the
//    // String representation of the arrays like below
//    public int findLength(int[] nums1, int[] nums2) {
//        int l1=nums1.length, l2=nums2.length;
//        int low=1, high=Math.min(l1, l2)+1;
//        StringBuilder sb=new StringBuilder();
//        for(int num: nums1){
//            sb.append((char)num);
//        }
//        String s1=sb.toString();
//        sb.setLength(0);
//        for(int num: nums2){
//            sb.append((char)num);
//        }
//        String s2=sb.toString();
//        while(low<high){
//            int mid=low+(high-low)/2;
//            if(hasRepeatedSubarrayOfLength(s1, s2, mid)){
//                low=mid+1;
//            } else{
//                high=mid;
//            }
//        }
//        return low-1;
//    }
//
//    private boolean hasRepeatedSubarrayOfLength(String s1, String s2, int length){
//        int l1=s1.length(), l2=s2.length();
//        Set<String> found=new HashSet<>();
//        for(int i=0; i<=l1-length; i++){
//            found.add(s1.substring(i, i+length));
//        }
//        for(int j=0; j<=l2-length; j++){
//            if(found.contains(s2.substring(j,j+length))){
//                return true;
//            }
//        }
//        return false;
//    }

//    // Brute force
//    public int findLength(int[] nums1, int[] nums2) {
//        int l1=nums1.length, l2=nums2.length, result=0;
//        for(int i=0; i<l1; i++){
//            if(l1-i>result){
//                int count=0;
//                int k=0;
//                while(i+k<l1 && k<l2){
//                    if(nums1[i+k]==nums2[k]){
//                        count++;
//                    } else{
//                        result=Math.max(result, count);
//                        count=0;
//                    }
//                    k++;
//                }
//                result=Math.max(result, count);
//            }
//        }
//        for(int j=0; j<l2; j++){
//            if(l2-j>result){
//                int count=0;
//                int k=0;
//                while(k<l1 && j+k<l2){
//                    if(nums1[k]==nums2[j+k]){
//                        count++;
//                    } else{
//                        result=Math.max(result, count);
//                        count=0;
//                    }
//                    k++;
//                }
//                result=Math.max(result, count);
//            }
//        }
//        return result;
//    }
}

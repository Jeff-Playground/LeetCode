package com.wen.FifteenthFifty;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=nums.length, max=nums[nums.length-1], min=nums[0];
        int[] noMoreCount=new int[(max-min)*2+1];
        int cur=0;
        for(int i=0; i<(max-min)*2+1; i++){
            while(cur<l && nums[cur]-min<=i){
                cur++;
            }
            noMoreCount[i]=cur;
        }

        int[] duplicateCount=new int[l];
        duplicateCount[0]=0;
        for(int i=1; i<l; i++){
            if(nums[i]==nums[i-1]){
                duplicateCount[i]=duplicateCount[i-1]+1;
            }
        }

        int left=0, right=max-min;
        while(left<right){
            int mid=left+(right-left)/2;
            int guess=0;
            for(int i=0; i<l && nums[i]-min+mid<(max-min)*2+1; i++){
                // This is to add the count for all pairs start with nums[i] and has diff<=mid
                guess+=noMoreCount[nums[i]-min+mid]-noMoreCount[nums[i]-min]+duplicateCount[i];
            }
            if(guess>=k){
                right=mid;
            } else{
                left=mid+1;
            }
        }
        return right;
    }

//    public int smallestDistancePair(int[] nums, int k) {
//        Arrays.sort(nums);
//        int l=nums.length;
//        int left=0, right=nums[l-1]-nums[0];
//        while(left<right){
//            int mid=left+(right-left)/2, start=0, count=0;
//            for(int i=0; i<l; i++){
//                // This is to add the count of pairs which ends with nums[i] and have a diff<=mid
//                while(start<l && nums[i]-nums[start]>mid){
//                    start++;
//                }
//                count+=i-start;
//            }
//            if(count<k){
//                left=mid+1;
//            } else{
//                right=mid;
//            }
//        }
//        return right;
//    }
}

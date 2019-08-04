package com.wen.TwelfthFifty;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        if(nums==null || nums.length==0){
            return result;
        }
        Map<Integer, Integer> sums=new HashMap<>();
        int sum=0;
        sums.put(sum, 1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            result+=sums.getOrDefault(sum-k, 0);
            sums.put(sum, sums.getOrDefault(sum, 0)+1);
        }
        return result;
    }

//    // Brute force
//    public int subarraySum(int[] nums, int k) {
//        int result=0;
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        int l=nums.length;
//        int[] sums=new int[l];
//        for(int i=0; i<l; i++){
//            if(i>0){
//                sums[i]=sums[i-1]+nums[i];
//            } else{
//                sums[i]=nums[i];
//            }
//        }
//        for(int i=l-1; i>=0; i--){
//            if(sums[i]==k){
//                result++;
//            }
//            for(int j=i-1; j>=0; j--){
//                if(sums[i]-sums[j]==k){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
}

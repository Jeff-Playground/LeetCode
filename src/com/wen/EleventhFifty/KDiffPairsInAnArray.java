package com.wen.EleventhFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    // Two pointers on sorted, sacrificed time for space O(1)
    public int findPairs(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<0){
            return 0;
        }
        Arrays.sort(nums);
        int result=0;
        int i=0, j=1;
        while(i<nums.length && j<nums.length){
            if(j<=i || nums[j]<nums[i]+k){
                j++;
            } else if(i-1>=0 && nums[i-1]==nums[i] || nums[i]+k<nums[j]){
                i++;
            } else{
                result++;
                i++;
            }
        }
        return result;
    }

//    // HashMap
//    public int findPairs(int[] nums, int k) {
//        if(nums==null || nums.length==0 || k<0){
//            return 0;
//        }
//        int result=0;
//        Map<Integer, Integer> count=new HashMap<>();
//        for(int num: nums){
//            count.put(num, count.getOrDefault(num, 0)+1);
//        }
//        for(Map.Entry<Integer, Integer> e: count.entrySet()){
//            if(k==0){
//                if(e.getValue()>1){
//                    result++;
//                }
//            } else{
//                if(count.containsKey(e.getKey()+k)){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
}

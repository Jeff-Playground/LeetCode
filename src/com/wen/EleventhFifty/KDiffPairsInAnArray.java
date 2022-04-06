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
        int left=0, right=1;
        while(left<nums.length && right<nums.length){
            // When left reaches right or right number is not big enough
            if(left==right || nums[right]-nums[left]<k){
                right++;
            // When current left number is equal to previous left number(will introduce duplicates), or left number is
            // to small
            } else if((left-1>=0 && nums[left-1]==nums[left]) || nums[right]-nums[left]>k){
                left++;
            // When the right number minus left number equals to k
            } else{
                result++;
                left++;
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

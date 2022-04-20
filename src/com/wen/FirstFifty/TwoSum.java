package com.wen.FirstFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int l=nums.length;
        Integer[] idx=new Integer[l];
        for(int i=0; i<l; i++){
            idx[i]=i;
        }
        Arrays.sort(idx, (a, b)->nums[a]-nums[b]);
        int left=0, right=l-1;
        while(left<right){
            if(nums[idx[left]]+nums[idx[right]]<target){
                left++;
            } else if(nums[idx[left]]+nums[idx[right]]>target){
                right--;
            } else{
                return new int[]{idx[left], idx[right]};
            }
        }
        return null;
    }

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> idx=new HashMap<>();
//        for(int i=0; i<nums.length; i++){
//            int num=nums[i];
//            if(idx.containsKey(target-num)){
//                return new int[]{idx.get(target-num), i};
//            } else{
//                idx.put(num, i);
//            }
//        }
//        return null;
//    }
}

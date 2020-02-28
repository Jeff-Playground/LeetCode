package com.wen.FifthFifty;

import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicateIII {
//    // Note convert int to long to avoid overflow
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j<nums.length && j-i<k+1; j++){
//                if(Math.abs((long)nums[i]-(long)nums[j])<=t){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length<2){
            return false;
        }
        int l=nums.length;
        TreeSet<Integer> window=new TreeSet<>();
        for(int i=0; i<l; i++){
            Integer low=window.floor(nums[i]);
            Integer high=window.ceiling(nums[i]);
            if((low!=null && (long)nums[i]-low<=t) || (high!=null && (long)high-nums[i]<=t)){
                return true;
            }
            window.add(nums[i]);
            // Note this won't remove duplicates from the window and cause problem because if there's duplicates, it
            // should already been identified as true and won't get to this step
            if(i>=k){
                window.remove(nums[i-k]);
            }
        }
        return false;
    }
}

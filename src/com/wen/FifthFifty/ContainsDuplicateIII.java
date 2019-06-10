package com.wen.FifthFifty;

public class ContainsDuplicateIII {
    // Note convert int to long to avoid overflow
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length && j-i<k+1; j++){
                if(Math.abs((long)nums[i]-(long)nums[j])<=t){
                    return true;
                }
            }
        }
        return false;
    }
}

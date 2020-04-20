package com.wen.FifteenthFifty;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result=0;
        if(nums==null || nums.length==0){
            return result;
        }
        int l=nums.length, left=0, right=0, cur=nums[0];
        while(left<l && right<l){
            if(cur<k){
                result+=right-left+1;
                if(right<l-1){
                    cur*=nums[++right];
                } else{
                    break;
                }
            } else{
                cur/=nums[left++];
            }
        }
        return result;
    }
}

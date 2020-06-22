package com.wen.SeventhFifty;

public class PatchingArray {
    // Note here miss need to be Long to avoid overflow
    public int minPatches(int[] nums, int n) {
        int l=nums.length, idx=0, result=0;
        long miss=1;
        while(miss<=n){
            if(idx>=l || nums[idx]>miss){
                result++;
                miss=2*miss;
            } else{
                while(idx<l && nums[idx]<=miss){
                    miss+=nums[idx];
                    idx++;
                }
            }
        }
        return result;
    }
}

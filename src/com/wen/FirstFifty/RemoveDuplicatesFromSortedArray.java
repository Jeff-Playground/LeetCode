package com.wen.FirstFifty;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int length=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            nums[length]=nums[i];
            length++;
        }
        return length;
    }
}

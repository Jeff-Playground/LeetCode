package com.wen.FirstFifty;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return nums.length;
        }
        int length=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val){
                continue;
            }
            nums[length]=nums[i];
            length++;
        }
        return length;
    }
}

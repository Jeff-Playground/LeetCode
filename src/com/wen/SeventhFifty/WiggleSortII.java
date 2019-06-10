package com.wen.SeventhFifty;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<2){
            return;
        }
        int[] temp= Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int mid=(temp.length-1)/2, right=temp.length-1;
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                nums[i]=temp[mid--];
            } else{
                nums[i]=temp[right--];
            }
        }
    }
}

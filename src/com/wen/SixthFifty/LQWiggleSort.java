package com.wen.SixthFifty;

import java.util.Arrays;

public class LQWiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<2){
            return;
        }
        int i=0;
        while(i+1<nums.length){
            if((i%2==0 && nums[i]>nums[i+1]) || (i%2==1 && nums[i]<nums[i+1])){
                int temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
            }
            i++;
        }
    }

//    public void wiggleSort(int[] nums) {
//        if(nums==null || nums.length<2){
//            return;
//        }
//        Arrays.sort(nums);
//        for(int i=1; i+1<nums.length; i+=2){
//            int temp=nums[i];
//            nums[i]=nums[i+1];
//            nums[i+1]=temp;
//        }
//    }
}

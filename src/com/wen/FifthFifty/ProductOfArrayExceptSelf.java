package com.wen.FifthFifty;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length<2){
            throw new IllegalArgumentException("Input array can't be null and has to contain at least 2 elements!");
        }
        int l=nums.length;
        int[] result=new int[l];
        Arrays.fill(result, 1);
        for(int i=1; i<l; i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int temp=nums[l-1];
        for(int i=l-2; i>=0; i--){
            result[i]*=temp;
            temp*=nums[i];
        }
        return result;
    }
}

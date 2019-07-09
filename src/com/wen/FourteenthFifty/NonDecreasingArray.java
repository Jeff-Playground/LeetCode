package com.wen.FourteenthFifty;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int l=nums.length;
        int changeTime=0;
        for(int i=1; i<l; i++){
            if(nums[i-1]>nums[i]){
                if(changeTime>0){
                    return false;
                }
                if(i==1 || nums[i-2]<=nums[i]){
                    nums[i-1]=nums[i];
                } else{
                    nums[i]=nums[i-1];
                }
                changeTime++;
            }
        }
        return true;
    }
}

package com.wen.FirstFifty;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        for(int k=0; k<nums.length; k++){
            int i=k+1, j=nums.length-1;
            while(i<j){
                int currentDiff=nums[k]+nums[i]+nums[j]-target;
                if(Math.abs(currentDiff)<Math.abs(diff)){
                    diff=currentDiff;
                }
                if(currentDiff>0){
                    j--;
                }else if(currentDiff<0){
                    i++;
                }else{
                    break;
                }
            }
        }
        return target+diff;
    }
}

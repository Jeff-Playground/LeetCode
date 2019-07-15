package com.wen.SixthFifty;

import java.util.Arrays;

public class LQ3SumSmaller {
    // T:O(n^2)
    public static int threeSumSmaller(int[] nums, int target) {
        if(nums==null || nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int l=nums.length;
        int result=0;
        for(int i=0; i<nums.length-2; i++){
            int remain=target-nums[i];
            int left=i+1, right=l-1;
            while(left<right){
                if(nums[left]+nums[right]>=remain){
                    right--;
                } else{
                    result+=right-left;
                    left++;
                }
            }
        }
        return result;
    }
}
